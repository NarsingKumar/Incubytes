package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import NegativeNumbersNotAllowedException.NegativeNumbersNotAllowedException;

class StringCalculator {
	
	String getDelimiter(String input) {
		if(Pattern.matches("//.\n.*", input)) {
			return input.charAt(input.indexOf("//")+2)+"";
		}
		return ",";
	}
	void validateNegativeNumbers(List<Integer> negativeList) throws NegativeNumbersNotAllowedException{
		if(negativeList.isEmpty()) {
			return;
		}
		StringBuilder errMsg = new StringBuilder();
		for(int n : negativeList ) {
			errMsg.append(n+", ");
		}
		throw new NegativeNumbersNotAllowedException("negative numbers are not allowed : " + errMsg.toString());
	}
    public int add(String input) throws NumberFormatException, NegativeNumbersNotAllowedException {
    	try {
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
    		
    		ArrayList<Integer> negativeNumbers = new ArrayList<>();
    		for(int i = 0 ; i<numbers.length;i++) {
    			int num = Integer.parseInt(numbers[i]);
    			if (num < 0) {
    				negativeNumbers.add(num);
    				continue;
    				}
    			
    			sum=sum+num;
    		}
    		validateNegativeNumbers(negativeNumbers);
    		return sum;
    	}
    	    
    }
    catch (NegativeNumbersNotAllowedException | NumberFormatException e) {
		System.err.println(e.getMessage()); 
		throw e;
	}

}
}