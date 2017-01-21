package basicrecursion;

public class MathRecursion {

	public static int findMax(int[] tal,int index,int max){
	
		//System.out.println(max);
		if(index==tal.length-1)
			return max;
		
		if(tal[index]>max){
				max=tal[index];
				 findMax(tal,index+1,max);
			}
		return findMax(tal,index+1,max);	
		
	
	}
	private static int findMax(int[] tal){
		int max=tal[0];
		return findMax(tal,1,max);
		
	}
        
        public static int findMaxIter(int[] tal){
            int max=tal[0];
            for(int i=0;i<tal.length;i++){
                if(tal[i]>max){
                    max=tal[i];
                }
            }
            return max;
        }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tal= {1,22,43,32,56,6};
		
		//System.out.println(tal[4]);
		System.out.println(findMax(tal));
                System.out.println(findMaxIter(tal));
                
                System.out.println(MathPowRecursive(5,3));
                
                System.out.printf("Roten: %.3f", MathSquare(82));
	}
        
        public static int MathPowRecursive(int value,int pow){
            return MathPowRecursive(value,pow,1);
        }
        
        public static int MathPowRecursive(int val,int pow,int loop){
            if(loop==pow){
                return val;
            }
            
            else{
                val=val*val;
                return MathPowRecursive(val,pow,loop+1);
            }
        }
        
        public static double MathSquare(double val ){
            return MathSquare(val,1,0.01);
        }
        
        public static double MathSquare(double val,double a,double e){
            
            if(Math.abs(a*a-val)<e){
                return a;
            }
            else{
                return MathSquare(val,(a*a+val)/(2*a),e);
            }
        }
}
