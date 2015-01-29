package nSim;

public class  Vector3d {
double x,y,z;
public  Vector3d(double x, double y, double z){
	this.x=x;
	this.y=y;
	this.z=z;
}
public  Vector3d(double x, double y){
	this(x,y,0);
}


public Vector3d multiply( Vector3d other){
	return this;
}
public Vector3d multiply(double x, double y, double z){
	this.x*=x;
	this.y*=y;
	this.z*=z;
	return this;
}

public Vector3d multiply(double x, double y){
	this.x*=x;
	this.y*=y;
	return this;
}

public Vector3d multiply(double x){
	this.x*=x;
	return this;
}
public Vector3d add( Vector3d other){
	this.x+=other.x;
	this.y+=other.y;
	this.z+=other.z;
	return this;
}

public Vector3d add(double x, double y, double z){
	this.x+=x;
	this.y+=y;
	this.z+=z;
	return this;
}

public Vector3d add(double x, double y){
	this.x+=x;
	this.y+=y;
	return this;
}

public Vector3d add(double x){
	this.x+=x;
	return this;
}
public double magnitudeSqrd(){
	return x*x+y*y+z*z;
}
@Override
	public String toString() {
		// TODO Auto-generated method stub
		return x+","+y+","+z;
	}
}
