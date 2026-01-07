package DYNtokenizer;

/**
 * Exception thrown when tokenization fails
 */
public class TokenizerException extends RuntimeException {
    private final int line;
    private final int column;

    public TokenizerException(String message, int line, int column) {
        super(String.format("Tokenizer error at line %d, column %d: %s", line, column, message));
        this.line = line;
        this.column = column;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }
}
