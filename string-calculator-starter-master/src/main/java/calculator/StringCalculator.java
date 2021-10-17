package calculator;

class StringCalculator {

    public int add(String input) {
    	if(input == null || input.isEmpty()) {
    		return 0;
    	} else if(input.length() == 1) {
    		return Integer.parseInt(input);
    	}  
    	else {
    		int sum=0;
    		
    		input = input.replaceAll("\n",",");
    		
    		String[] numbers = input.split(",");
    		
    		for(int i = 0 ; i<numbers.length;i++) {
    			int num = Integer.parseInt(numbers[i]);
    			sum=sum+num;
    		}
    		
    		return sum;
    	}
    	    
    }

}