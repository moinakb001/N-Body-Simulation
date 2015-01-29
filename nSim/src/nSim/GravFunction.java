package nSim;

public class GravFunction implements Function {
	final double G;
	public GravFunction() {
		// TODO Auto-generated constructor stub
		G=6.67384e-11;
		//G=33.5e-12;
	}
	 public GravFunction(double G){
		 this.G=G;
	 }
	@Override
	public  Vector3d getFunction(PhysicsObject o1, PhysicsObject o2) {
		// TODO Auto-generated method stub
		
		Vector3d pos1=o1.position;
		Vector3d pos2=o2.position;
		
		Vector3d diff=new Vector3d(pos2.x-pos1.x, pos2.y-pos1.y,pos2.z-pos1.z);
		
		double r2=diff.magnitudeSqrd();
		double r=Math.sqrt(r2);
		
		double F_g=G*o2.mass/r2;
		//System.out.println(F_g);
		diff=diff.multiply(F_g/r,F_g/r,F_g/r);
		
		//System.out.println("This: "+diff);
		return diff;
		
	}

}
