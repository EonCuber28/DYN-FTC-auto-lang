import java.util.*;
import java.util.regex.*;

// admitadley written by Claude Sonnet 4.5
public class DynTokenizer {

    public enum TokenType {
        // Keywords
        DEF_PATH, RUN, AUTOPATH, PATH_START_POSITION,
        NUM, BOOL, STRING, FIELDCOORD, FIELDPOS, LIST, JSON,
        ADD, SUB, MUX, DIV, POW, SQR, SIN, INVSIN, COS, INVCOS, TAN, INVTAN,
        TURNTO, GOTO, FOLLOWBEZIER, OUTPUT2TELEM,
        WHILE, FOR, IF, AS, TO,
        START, END,

        // Literals
        NUMBER, STRING_LITERAL, BOOLEAN, IDENTIFIER,

        // Operators & Punctuation
        LPAREN, RPAREN, LBRACKET, RBRACKET, LBRACE, RBRACE,
        COMMA, COLON, EQUALS,
        LESS_THAN, GREATER_THAN, LESS_EQUAL, GREATER_EQUAL, EQUAL_EQUAL, NOT_EQUAL,

        // Special
        COMMENT, MULTILINE_COMMENT, NEWLINE, EOF, UNKNOWN
    }

    public static class Token {
        public final TokenType type;
        public final String value;
        public final int line;
        public final int column;

        public Token(TokenType type, String value, int line, int column) {
            this.type = type;
            this.value = value;
            this.line = line;
            this.column = column;
        }

        @Override
        public String toString() {
            return String.format("Token(%s, '%s', %d:%d)", type, value, line, column);
        }
    }

    private final String source;
    private int pos = 0;
    private int line = 1;
    private int column = 1;
    private List<Token> tokens = new ArrayList<>();

    private final Map<String, TokenType> keywords = new HashMap<>();

    public DynTokenizer(String source) {
        this.source = source;
        initializeKeywords();
    }

    private void initializeKeywords() {
        keywords.put("def_path", TokenType.DEF_PATH);
        keywords.put("RUN", TokenType.RUN);
        keywords.put("autoPath", TokenType.AUTOPATH);
        keywords.put("PathStartPosition", TokenType.PATH_START_POSITION);

        keywords.put("Num", TokenType.NUM);
        keywords.put("Bool", TokenType.BOOL);
        keywords.put("String", TokenType.STRING);
        keywords.put("FieldCoord", TokenType.FIELDCOORD);
        keywords.put("FieldPos", TokenType.FIELDPOS);
        keywords.put("List", TokenType.LIST);
        keywords.put("Json", TokenType.JSON);

        keywords.put("ADD", TokenType.ADD);
        keywords.put("SUB", TokenType.SUB);
        keywords.put("MUX", TokenType.MUX);
        keywords.put("DIV", TokenType.DIV);
        keywords.put("POW", TokenType.POW);
        keywords.put("SQR", TokenType.SQR);
        keywords.put("SIN", TokenType.SIN);
        keywords.put("invSIN", TokenType.INVSIN);
        keywords.put("COS", TokenType.COS);
        keywords.put("invCOS", TokenType.INVCOS);
        keywords.put("TAN", TokenType.TAN);
        keywords.put("invTAN", TokenType.INVTAN);

        keywords.put("turnTo", TokenType.TURNTO);
        keywords.put("goTo", TokenType.GOTO);
        keywords.put("followBezier", TokenType.FOLLOWBEZIER);
        keywords.put("output2telem", TokenType.OUTPUT2TELEM);

        keywords.put("while", TokenType.WHILE);
        keywords.put("for", TokenType.FOR);
        keywords.put("if", TokenType.IF);
        keywords.put("as", TokenType.AS);
        keywords.put("to", TokenType.TO);

        keywords.put("start", TokenType.START);
        keywords.put("end", TokenType.END);

        keywords.put("true", TokenType.BOOLEAN);
        keywords.put("false", TokenType.BOOLEAN);
    }

    public List<Token> tokenize() {
        while (pos < source.length()) {
            char c = source.charAt(pos);

            // Handle multiline comments (''' at start of line)
            if (c == '\'' && pos + 2 < source.length() &&
                    source.charAt(pos + 1) == '\'' && source.charAt(pos + 2) == '\'' &&
                    (pos == 0 || source.charAt(pos - 1) == '\n')) {
                tokenizeMultilineComment();
                continue;
            }

            // Handle single-line comments
            if (c == '/' && pos + 1 < source.length() && source.charAt(pos + 1) == '/') {
                tokenizeSingleLineComment();
                continue;
            }

            // Whitespace (excluding newlines)
            if (c == ' ' || c == '\t' || c == '\r') {
                advance();
                continue;
            }

            // Newlines
            if (c == '\n') {
                addToken(TokenType.NEWLINE, "\n");
                advance();
                line++;
                column = 1;
                continue;
            }

            // String literals
            if (c == '"') {
                tokenizeString();
                continue;
            }

            // Numbers
            if (Character.isDigit(c) || (c == '-' && pos + 1 < source.length() &&
                    Character.isDigit(source.charAt(pos + 1)))) {
                tokenizeNumber();
                continue;
            }

            // Identifiers and keywords
            if (Character.isLetter(c) || c == '_') {
                tokenizeIdentifier();
                continue;
            }

            // Operators and punctuation
            switch (c) {
                case '(': addToken(TokenType.LPAREN, "("); advance(); break;
                case ')': addToken(TokenType.RPAREN, ")"); advance(); break;
                case '[': addToken(TokenType.LBRACKET, "["); advance(); break;
                case ']': addToken(TokenType.RBRACKET, "]"); advance(); break;
                case '{': addToken(TokenType.LBRACE, "{"); advance(); break;
                case '}': addToken(TokenType.RBRACE, "}"); advance(); break;
                case ',': addToken(TokenType.COMMA, ","); advance(); break;
                case ':': addToken(TokenType.COLON, ":"); advance(); break;
                case '=':
                    if (pos + 1 < source.length() && source.charAt(pos + 1) == '=') {
                        addToken(TokenType.EQUAL_EQUAL, "==");
                        advance(); advance();
                    } else {
                        addToken(TokenType.EQUALS, "=");
                        advance();
                    }
                    break;
                case '<':
                    if (pos + 1 < source.length() && source.charAt(pos + 1) == '=') {
                        addToken(TokenType.LESS_EQUAL, "<=");
                        advance(); advance();
                    } else {
                        addToken(TokenType.LESS_THAN, "<");
                        advance();
                    }
                    break;
                case '>':
                    if (pos + 1 < source.length() && source.charAt(pos + 1) == '=') {
                        addToken(TokenType.GREATER_EQUAL, ">=");
                        advance(); advance();
                    } else {
                        addToken(TokenType.GREATER_THAN, ">");
                        advance();
                    }
                    break;
                case '!':
                    if (pos + 1 < source.length() && source.charAt(pos + 1) == '=') {
                        addToken(TokenType.NOT_EQUAL, "!=");
                        advance(); advance();
                    } else {
                        addToken(TokenType.UNKNOWN, "!");
                        advance();
                    }
                    break;
                default:
                    addToken(TokenType.UNKNOWN, String.valueOf(c));
                    advance();
            }
        }

        addToken(TokenType.EOF, "");
        return tokens;
    }

    private void tokenizeSingleLineComment() {
        int start = pos;
        while (pos < source.length() && source.charAt(pos) != '\n') {
            advance();
        }
        addToken(TokenType.COMMENT, source.substring(start, pos));
    }

    private void tokenizeMultilineComment() {
        int start = pos;
        pos += 3; // Skip opening '''
        column += 3;

        // Find closing ''' at start of a line
        while (pos < source.length()) {
            if (source.charAt(pos) == '\n') {
                advance();
                line++;
                column = 1;
                // Check if next chars are ''' at start of line
                if (pos + 2 < source.length() &&
                        source.charAt(pos) == '\'' &&
                        source.charAt(pos + 1) == '\'' &&
                        source.charAt(pos + 2) == '\'') {
                    pos += 3;
                    column += 3;
                    break;
                }
            } else {
                advance();
            }
        }
        addToken(TokenType.MULTILINE_COMMENT, source.substring(start, pos));
    }

    private void tokenizeString() {
        int start = pos;
        advance(); // Skip opening "

        while (pos < source.length() && source.charAt(pos) != '"') {
            if (source.charAt(pos) == '\\' && pos + 1 < source.length()) {
                advance(); // Skip escape char
            }
            advance();
        }

        if (pos < source.length()) {
            advance(); // Skip closing "
        }

        addToken(TokenType.STRING_LITERAL, source.substring(start, pos));
    }

    private void tokenizeNumber() {
        int start = pos;

        if (source.charAt(pos) == '-') {
            advance();
        }

        while (pos < source.length() && Character.isDigit(source.charAt(pos))) {
            advance();
        }

        // Handle decimal point
        if (pos < source.length() && source.charAt(pos) == '.' &&
                pos + 1 < source.length() && Character.isDigit(source.charAt(pos + 1))) {
            advance(); // Skip '.'
            while (pos < source.length() && Character.isDigit(source.charAt(pos))) {
                advance();
            }
        }

        addToken(TokenType.NUMBER, source.substring(start, pos));
    }

    private void tokenizeIdentifier() {
        int start = pos;

        while (pos < source.length() &&
                (Character.isLetterOrDigit(source.charAt(pos)) || source.charAt(pos) == '_')) {
            advance();
        }

        String value = source.substring(start, pos);
        TokenType type = keywords.getOrDefault(value, TokenType.IDENTIFIER);
        addToken(type, value);
    }

    private void addToken(TokenType type, String value) {
        tokens.add(new Token(type, value, line, column - value.length()));
    }

    private void advance() {
        pos++;
        column++;
    }
}