public class ArrayDemo{
	public static void main(String args[]){
		int[] demo = new int [5];
		demo[0] = 96;
		demo[1] = -35;
		demo[2] = demo[0] + demo[1];
		demo[3] = demo[0] + demo[1];
		demo[4] = demo[3] + demo[1];
		System.out.println(demo[0] + ", " + demo[1] + ", " + demo[2] + ", " + demo[3] + ", " + demo[4]);
	}
}