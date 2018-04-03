import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class MaxTemperatureReducerCounter
  extends Reducer<Text, IntWritable, Text, IntWritable> {

  @Override
  public void reduce(Text key, Iterable<IntWritable> values,
      Context context)
      throws IOException, InterruptedException {

    int maxValue = Integer.MIN_VALUE;
//    String pattern = "[+-]?\\d{1,3}(,\\d{3})*\\.?\\d+";
String pattern = ".*[^0-9].*";
    int ctMalformed=0;
    int ctInvalid=0;
    for (IntWritable value : values) {
     // maxValue = Math.max(maxValue, value.get());
//      if (value.get() < -273.15){
      if((value.get() < -88) || (value.get() > 58) ){
      ctInvalid++;
      }
String badRecords=String.valueOf(value.get());
       Pattern r = Pattern.compile(pattern);
      Matcher m = r.matcher(badRecords);
      if (!m.find( )) {
      ctMalformed++;
}

    }
    context.write(key, new IntWritable(ctInvalid));
    context.write(key, new IntWritable(ctMalformed));
  }
}
// ^^ MaxTemperatureReducer
