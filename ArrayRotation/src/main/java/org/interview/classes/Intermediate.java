package org.interview.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Intermediate {

    //---------------------------------------Attributes
    private List<Integer> inputArray;
    private Integer rate;
    //---------------------------------------
    public List<Integer> getOutputArray() throws Exception{
        List<Integer> outputArray=new ArrayList<Integer>();
        if (null == inputArray || inputArray.size()==0){
            throw new IllegalArgumentException("invalid inputArray!");
        }
        if (null==rate || rate <= 0){
            throw new IllegalArgumentException("invalid rate!");
        }
        if (rate > inputArray.size()){
           rate=inputArray.size()%rate;
        }
        int piece=inputArray.size()/rate;
        int reminded=inputArray.size()%rate;
        for (int i=0;i<piece;i++){
            for (int j=((rate*i)+rate)-1;j>=(rate*i);j--){
                outputArray.add(inputArray.get(j));
            }
        }
        for (int i=(rate*piece)+reminded-1;i>=(rate*piece);i--){
            outputArray.add(inputArray.get(i));
        }
        return outputArray;
    }
}
