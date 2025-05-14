package ss6_ke_thua.bai_tap.point2DAndPoint3D;

public class Point3D extends Point2D{
    private float z=0.0f;
    public Point3D(){
    }
    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public void setXYZ(float x,float y,float z){
        setXY(x,y);
        this.z =z;
    }
    public float[] getXYZ(){
        float[] arr = {getX(),getY(),z};
        return arr;
    }
    @Override
    public String toString(){
        return String.format("(%.1f,%.1f,%.1f)",getX(),getY(),z);
    }
}
