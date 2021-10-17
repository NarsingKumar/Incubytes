package calculator;

import java.util.regex.Pattern;

class StringCalculator {
	
	String getDelimiter(String input) {
		if(Pattern.matches("//.\n.*", input)) {
			return input.charAt(input.indexOf("//")+2)+"";
		}
		return ",";
	}

    public int add(String input) {
    	if(input == null || input.isEmpty()) {
    		return 0;
    	} else if(input.length() == 1) {
    		return Integer.parseInt(input);
    	}  
    	else {
    		int sum=0;
    		String delimiter = getDelimiter(input);
    		input = input.replaceAll("//.\n","");
    		input = input.replaceAll("\n",delimiter);
    		
    		String[] numbers = input.split(delimiter);
    		
    		for(int i = 0 ; i<numbers.length;i++) {
    			int num = Integer.parseInt(numbers[i]);
    			sum=sum+num;
    		}
    		
    		return sum;
    	}
    	    
    }

}