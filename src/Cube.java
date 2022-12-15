import java.awt.Polygon;


public class Cube {
	Polygon[] sides = new Polygon[6];
	int Xoffset, Yoffset;
    int constZ = 50;
	double[] centrePoint;
	double[][] points3D;
	int[][] points2D = new int[8][2];
	double degrees = 0;
	
	Cube(int size, double[] point0, int constXoffset, int constYoffset){
		Xoffset = constXoffset;
		Yoffset = constYoffset;
		
		centrePoint = new double[] {size/2, size/2, size/2};

		double[][] tempPoints = {
			{point0[0], point0[1], point0[2]},
			{point0[0]+size, point0[1], point0[2]},
			{point0[0], point0[1], point0[2]+size},
			{point0[0]+size, point0[1], point0[2]+size},
			{point0[0], point0[1]+size, point0[2]},
			{point0[0]+size, point0[1]+size, point0[2]},
			{point0[0], point0[1]+size, point0[2]+size},
			{point0[0]+size, point0[1]+size, point0[2]+size}
		};
		
		points3D = tempPoints;
		
		updateSides();
		
    }

	void updateSides(){
		calcPos2D();
		sides[0] = new Polygon(	new int[] {points2D[0][0]+Xoffset, points2D[1][0]+Xoffset, points2D[3][0]+Xoffset, points2D[2][0]+Xoffset},
								new int[] {points2D[0][1]+Yoffset, points2D[1][1]+Yoffset, points2D[3][1]+Yoffset, points2D[2][1]+Yoffset}, 4);
		sides[1] = new Polygon(	new int[] {points2D[4][0]+Xoffset, points2D[5][0]+Xoffset, points2D[7][0]+Xoffset, points2D[6][0]+Xoffset},
								new int[] {points2D[4][1]+Yoffset, points2D[5][1]+Yoffset, points2D[7][1]+Yoffset, points2D[6][1]+Yoffset}, 4);
		sides[2] = new Polygon(	new int[] {points2D[0][0]+Xoffset, points2D[1][0]+Xoffset, points2D[5][0]+Xoffset, points2D[4][0]+Xoffset},
								new int[] {points2D[0][1]+Yoffset, points2D[1][1]+Yoffset, points2D[5][1]+Yoffset, points2D[4][1]+Yoffset}, 4);
		sides[3] = new Polygon(	new int[] {points2D[1][0]+Xoffset, points2D[3][0]+Xoffset, points2D[7][0]+Xoffset, points2D[5][0]+Xoffset},
								new int[] {points2D[1][1]+Yoffset, points2D[3][1]+Yoffset, points2D[7][1]+Yoffset, points2D[5][1]+Yoffset}, 4);
		sides[4] = new Polygon(	new int[] {points2D[3][0]+Xoffset, points2D[2][0]+Xoffset, points2D[6][0]+Xoffset, points2D[7][0]+Xoffset},
								new int[] {points2D[3][1]+Yoffset, points2D[2][1]+Yoffset, points2D[6][1]+Yoffset, points2D[7][1]+Yoffset}, 4);
		sides[5] = new Polygon(	new int[] {points2D[2][0]+Xoffset, points2D[0][0]+Xoffset, points2D[4][0]+Xoffset, points2D[6][0]+Xoffset},
								new int[] {points2D[2][1]+Yoffset, points2D[0][1]+Yoffset, points2D[4][1]+Yoffset, points2D[6][1]+Yoffset}, 4);
								
	}


    void calcPos2D(){

		for (int i = 0; i < 8; i++) {
			points2D[i][0] = (int) ((points3D[i][2] * points3D[i][0]) / (points3D[i][2]+constZ));
			points2D[i][1] = (int) ((points3D[i][2] * points3D[i][1]) / (points3D[i][2]+constZ));
				
		}
	}

	void calcRotation(){
		double tempZ, tempY;
		double radians = Math.toRadians(degrees);
		for (int i = 0; i < points3D.length; i++) {
			tempZ = points3D[i][0];
			tempY = points3D[i][1];
			points3D[i][0] -= centrePoint[0];
			points3D[i][0] = (tempZ * Math.cos(radians)) - (tempY * Math.sin(radians));

			points3D[i][1] -= centrePoint[0];
			points3D[i][1] = (tempY * Math.cos(radians)) + (tempZ * Math.sin(radians));
			
		}

	}

	void sideOrder(){
		
		for (int i = 0; i < 6; i++) {
			
		}
	}


	void moveBackward(){
		for (int i = 0; i < points3D.length; i++) {
			points3D[i][2] += 10;		
		}
		constZ += 10;
		updateSides();
	}
	void moveForward(){
		for (int i = 0; i < points3D.length; i++) {
			points3D[i][2] -= 10;			
		}
		constZ -= 10;
		updateSides();
	}
	void rotateRight(){
		degrees += 1;
		calcRotation();
		updateSides();
	}
	void rotateLeft(){
		degrees -= 1;
		calcRotation();
		updateSides();
	}
	void moveLeft(){
		for (int i = 0; i < points3D.length; i++) {
			points3D[i][0] -= 15;			
		}
		updateSides();
	}
	void moveRight(){
		for (int i = 0; i < points3D.length; i++) {
			points3D[i][0] += 15;			
		}
		updateSides();
	}
	void moveUp(){
		for (int i = 0; i < points3D.length; i++) {
			points3D[i][1] -= 15;			
		}
		updateSides();
	}
	void moveDown(){
		for (int i = 0; i < points3D.length; i++) {
			points3D[i][1] += 15;			
		}
		updateSides();
	}

}