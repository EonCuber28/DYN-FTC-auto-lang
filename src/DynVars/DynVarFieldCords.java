package DynVars;

// DONE

public class DynVarFieldCords {
    public String name;
    public DynVarNumber PosX;
    public DynVarNumber PosY;
    // instantiators
    public DynVarFieldCords(double state, String name){this.name = name;}
    public DynVarFieldCords(DynVarNumber PosX, DynVarNumber PosY, String name){this.PosX=PosX;this.PosY=PosY;this.name=name;}
    public DynVarFieldCords(double PosX, double PosY, String name){this.PosX = new DynVarNumber(PosX, name);this.PosY = new DynVarNumber(PosY, name);this.name = name;}
    public DynVarFieldCords(double[] Pos, String name){this.PosX = new DynVarNumber(Pos[0], name);this.PosY = new DynVarNumber(Pos[1], name);this.name = name;}
    // to debug string
    public String toDebugString(){
        return "Field Cord: "+name+" X:"+PosX.toString()+" Y:"+PosY.toString();
    }
    // to java string
    public String toString(){return "("+PosX+", "+PosY+")";}
    // to DYN string
    public DynVarString toDYNString(){return new DynVarString(this.toString(), name);}
    // to pedro position (WIP)
    // to dyn field position
    public DynVarFieldPos toFieldPos(){
        return new DynVarFieldPos(PosX, PosY, new DynVarNumber(name), name);
    }
    // to list
    public DynVarList toList(){
        DynVarList list = new DynVarList(name);
        list.append(PosX);
        list.append(PosY);
        return list;
    }
    // to json
    public DynVarJson toJson(){
        DynVarJson json = new DynVarJson(name);
        json.add("PosX", PosX);
        json.add("PosY", PosY);
        return json;
    }
    // equals
    public boolean equals(DynVarFieldPos in){return (in.PosX == PosX && in.PosY == PosY);}
    public boolean equals(DynVarFieldCords in){return (in.PosX == PosX && in.PosY == PosY);}

}