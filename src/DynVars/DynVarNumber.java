package DynVars;

public class DynVarNumber {
    public String name  = "";
    public double value;
    // instantiators
    public DynVarNumber(double in, String Name){value = in;name = Name;}
    public DynVarNumber(float in, String Name){value = in;name = Name;}
    public DynVarNumber(int in, String Name){value = in;name = Name;}
    public DynVarNumber(String Name){value = 0;name = Name;}
    // to dyn string
    public DynVarString toDynStr(){return new DynVarString(toString(), name);}
    // to java number
    public double toNum(){return value;}
    // to debug string
    public String toDebugString(){return "DYNnum: "+name+" value:"+value;}
    // to java string
    public String toString(){return String.valueOf(value);}
    // to dyn string
    public DynVarString toDynString(){return new DynVarString(toString(),name);}
    // set to add
    public void setToAdd(DynVarNumber in1, DynVarNumber in2){value = in1.value+ in2.value;}
    public void setToAdd(DynVarNumber in){value += in.value;}
    // set to sub
    public void setToSub(DynVarNumber in1, DynVarNumber in2){value = in1.value-in2.value;}
    public void setToSub(DynVarNumber in){value -= in.value;}
    // set to mux
    public void setToMux(DynVarNumber in1, DynVarNumber in2){value = in1.value*in2.value;}
    public void setToMux(DynVarNumber in){value *= in.value;}
    // set to div
    public void setToDiv(DynVarNumber in1, DynVarNumber in2){value = in1.value/in2.value;}
    public void setToDiv(DynVarNumber in){value /= in.value;}
    // set to power
    public void setToPow(DynVarNumber in1, DynVarNumber in2){value = Math.pow(in1.value, in2.value);}
    public void setToPow(DynVarNumber in){value = Math.pow(value, in.value);}
    // set to sqrt
    public void setToSqr(DynVarNumber in){value = Math.sqrt(in.value);}
    // set to sin
    public void setToSin(DynVarNumber in){value = Math.sin(in.value);}
    // set to inv-sin
    public void setToIsn(DynVarNumber in){value = 1/Math.sin(in.value);}
    // set to cos
    public void setToCos(DynVarNumber in){value = Math.cos(in.value);}
    // set to inv-cos
    public void setToIco(DynVarNumber in){value = 1/Math.cos(in.value);}
    // sst to tan
    public void setToTan(DynVarNumber in){value = Math.tan(in.value);}
    // set to inv-tan
    public void setToItn(DynVarNumber in){value = 1/Math.tan(in.value);}
    // equals
    public boolean equals(DynVarNumber in){return (in.value == value);}
    public boolean equals(double in){return (in == value);}
    public boolean equals(int in){return (in == value);}
    public boolean equals(float in){return (in == value);}
    public boolean equals(Object in){return false;}
}
