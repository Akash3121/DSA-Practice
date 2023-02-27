//925. Long Pressed Name

//Java
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int typedPointer = 0, namePointer = 0;
        //i is namePointer and j is typedPointer

        if (typed.charAt(0) != name.charAt(0)){ //first char not same then not equals
            return false;
        }

        //two pointer
        while( typedPointer < typed.length() && namePointer < name.length()){
            if ( typed.charAt(typedPointer) == name.charAt(namePointer)){ //both are equal
                typedPointer ++;
                namePointer ++;
            }
            else{ //not equal
                //check in typed string with previous char 
                if (typed.charAt(typedPointer) == typed.charAt(typedPointer - 1)){
                    typedPointer++;
                } else{
                    return false; //not equal
                }
            }
        }

        //at the end of the strings - 
        //case 1: both are at the end of strings
        if (typedPointer == typed.length() && namePointer == name.length()){
            return true;
        }

        //case 2: if name is not completely traversed
        else if(namePointer != name.length() && typedPointer == typed.length()){
            return false;
        }

        //case 3:name is complete and typed word is not completed
        else{
            while (typedPointer < typed.length()){
                if (typed.charAt(typedPointer) == typed.charAt(typedPointer - 1)){
                    typedPointer++;
                } else{
                    return false;
                }
            }
        }

        return true;
    }
}