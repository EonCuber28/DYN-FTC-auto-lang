package DynVars;

// DONE

public class DynVarBoolean {
    public String name  = "";
    public boolean value = true;
    // instantiators
    public DynVarBoolean(Boolean state, String name){value = state; this.name = name;}
    public DynVarBoolean(String name){this.name = name;}
    // to debug string
    public String toDebugStr(){return "Boolean name: "+name+" value: "+value;}
    // to dyn string
    public DynVarString toDynStr(){return new DynVarString(String.valueOf(value), name);}
    // to java string
    public String toStr(){return String.valueOf(value);};
    // to java bool
    public Boolean toBool(){return value;}
    // equals
    public Boolean equals(DynVarBoolean in){return (value == in.value);}
    // 2 variables equal
    public void setToEquals(DynVarFieldCords in1, DynVarFieldCords in2){value = in1.equals(in2);}
    public void setToEquals(DynVarFieldPos in1, DynVarFieldPos in2){value = in1.equals(in2);}
    public void setToEquals(DynVarNumber in1, DynVarNumber in2){value = in1.equals(in2);}
    public void setToEquals(DynVarString in1, DynVarString in2){value = in1.equals(in2);}
    public void setToEquals(DynVarJson in1, DynVarJson in2){value = in1.equals(in2);}
    public void setToEquals(DynVarList in1, DynVarList in2){value = in1.equals(in2);}
    // and
    public Boolean getAnd(DynVarBoolean in1, DynVarBoolean in2){return (in1.value && in2.value);}
    public void setToAnd(DynVarBoolean in){value = (in.value && value);}
    // or
    public Boolean getOr(DynVarBoolean in1, DynVarBoolean in2){return (in1.value && in2.value);}
    public void setToOr(DynVarBoolean in){value = (in.value && value);}
}
