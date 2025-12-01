package DynVars;

public class DynVarFieldPos {
    public String name;
    public DynVarNumber PosX;
    public DynVarNumber PosY;
    public DynVarNumber Heading;
    // instantiators
    public DynVarFieldPos(String name){
        this.name = name;
        PosX = new DynVarNumber(name);
        PosY = new DynVarNumber(name);
        Heading = new DynVarNumber(name);
    }
    public DynVarFieldPos(DynVarNumber PosX, DynVarNumber PosY, DynVarNumber Heading, String name){
        this.name = name;
        this.PosX = PosX;
        this.PosY = PosY;
        this.Heading = Heading;
    }
    public DynVarFieldPos(double[] Pos, String name){
        this.name = name;
        this.PosX = new DynVarNumber(Pos[0], name);
        this.PosY = new DynVarNumber(Pos[1], name);
        this.Heading = new DynVarNumber(Pos[2], name);
    }
    // to dyn field cord
    public DynVarFieldCords toFieldCord(){return new DynVarFieldCords(PosX,PosY,name);}
    // to debug string
    public String toDebugString(){return "Field Position Var: "+name+" X:"+PosX+" Y:"+PosY+" Heading:"+Heading;}
    // to java string
    public String toString(){return "("+PosX+", "+PosY+", "+Heading+")";}
    // to dyn string
    public DynVarString toDynStr(){return new DynVarString(toString(), name);}
    // pedro position (WIP)

    // equals
    public boolean equals(DynVarFieldPos in){return (in.PosX == PosX && in.PosY == PosY && in.Heading == Heading);}
    public boolean equals(DynVarFieldCords in){return (in.PosX == PosX && in.PosY == PosY);}
    public boolean equals(Object in){return false;}
}
