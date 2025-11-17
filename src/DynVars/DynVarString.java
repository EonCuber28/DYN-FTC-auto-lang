package DynVars;

public class DynVarString {
    public String name;
    public String value = "";
    // instantiators
    public DynVarString(String name){this.name = name;}
    public DynVarString(String value, String name){this.name = name; this.value = value;}
    // set to add (WIP)
    public void setToAdd(DynVarFieldCords in){value += in.toString();}
    public void setToAdd(DynVarFieldPos in){value += in.toString();}
    public void setToAdd(DynVarBoolean in){value += in.toString();}
    public void setToAdd(DynVarNumber in){value += in.toString();}
    public void setToAdd(DynVarString in){value += in.toString();}
    public void setToAdd(DynVarJson in){value += in.toString();}
    public void setToAdd(DynVarList in){value += in.toString();}
    public void setToAdd(Object in1, Object in2){value = in1.toString()+in2.toString();}
}
