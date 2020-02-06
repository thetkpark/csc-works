import java.util.Vector;

/**
 * Star
 */
public class Star {
    private int starNumber;
    private boolean hasLight;
    Vector<String> material;
    private double age;
    private double diameter;
    private double maxTemperature;
    private double minTemperature;

    public Star(){
        this.starNumber = 0;
        this.hasLight = false;
        this.age = 1000000;
        this.diameter = 20000;
        this.maxTemperature = 100;
        this.minTemperature = 0;
        this.material = new Vector<String>(10);
    }

    public Star(int num, boolean light, double age, double diameter, double maxtemp, double mintemp){
        this.starNumber = num;
        this.hasLight = light;
        this.age = age;
        this.diameter = diameter;
        this.maxTemperature = maxtemp;
        this.minTemperature = mintemp;
        this.material = new Vector<String>();
    }


    public String toString() {
        return "{" +
            " starNumber='" + getStarNumber() + "'" +
            ", hasLight='" + isHasLight() + "'" +
            ", material='" + getAllMeterial() + "'" +
            ", age='" + getAge() + "'" +
            ", diameter='" + getDiameter() + "'" +
            ", maxTemperature='" + getMaxTemperature() + "'" +
            ", minTemperature='" + getMinTemperature() + "'" +
            "}";
    }


    public String getMaterial(int i){
        String m="";
        for(int j=0;j<this.material.size();j++){
            if(i-1==j){
                m = this.material.get(j);
            }
        } 
        return m;
    }

    public String getAllMeterial(){
        String allMat = "";
        for(String x: this.material){
            allMat = allMat + (x + ", ");
        }
        return allMat;
    }

    public void addMaterial(String mat){
        this.material.add(mat);
    }

    public double getVolumn(){
        return Math.PI*4/3*Math.pow(this.getDiameter()/2, 3);
    }



    public int getStarNumber() {
		return this.starNumber;
	}

	public void setStarNumber(int starNumber) {
		this.starNumber = starNumber;
	}

	public boolean isHasLight() {
		return this.hasLight;
	}

	public void setHasLight(boolean hasLight) {
		this.hasLight = hasLight;
	}

	public double getAge() {
		return this.age;
	}

	public void setAge(double age) {
		this.age = age;
	}

	public double getDiameter() {
		return this.diameter;
	}

	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}

	public double getMaxTemperature() {
		return this.maxTemperature;
	}

	public void setMaxTemperature(double maxTemperature) {
		this.maxTemperature = maxTemperature;
	}

	public double getMinTemperature() {
		return this.minTemperature;
	}

	public void setMinTemperature(double minTemperature) {
		this.minTemperature = minTemperature;
	}

}