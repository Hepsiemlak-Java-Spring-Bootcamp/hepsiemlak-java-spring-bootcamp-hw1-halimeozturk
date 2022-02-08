package Question;

public class Question1 {
    public void result(){
        int maxCount = 0;
        int maxValue = 0;
        for(int i =10;i<101;i++){
            int[] value = palindrom(i,0);
            int temp = Math.max(value[1],maxCount);
            maxValue = temp != maxCount ? i : maxValue;
            maxCount = temp;
        }
        System.out.println("maxCount ==== >   " +  maxCount  +  "    maxValue ==== >"+  maxValue);
    }

    public int[] palindrom(int i, int count){

        int palindrom = i;
        int firstValue = palindrom;
        int length1 = String.valueOf(palindrom).length();
        int remainder,value=0;
        for (int j = 0; j<length1; j++){
            remainder = palindrom % 10;
            value = value * 10 + remainder;
            palindrom = palindrom / 10;
        }

        if(value == firstValue){
            System.out.println(value + " Palindrom Sayidir.");
            return new int[]{value, count};
        }
        System.out.println("Palindrom Sayi Degildir. ======>>>>>>>>>> " + value);

        return palindrom((value + firstValue),++count);

    }


}
