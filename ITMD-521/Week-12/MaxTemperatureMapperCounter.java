import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class MaxTemperatureMapperCounter
  extends Mapper<LongWritable, Text, Text, IntWritable>
{
  private static final int MISSING = 9999;

  public void map(LongWritable paramLongWritable, Text paramText, Mapper<LongWritable, Text, Text, IntWritable>.Context paramMapper)
    throws IOException, InterruptedException
  {
    String str1 = paramText.toString();
    try {
    String str2 = str1.substring(15, 19);

    int i;
                        try {
                                if (str1.charAt(87) == '+') {
                                  i = Integer.parseInt(str1.substring(88, 92));
                                } else {
                                  i = Integer.parseInt(str1.substring(87, 92));
                                }

   String str3 = str1.substring(92, 93);
   if ((i != 9999) && (str3.matches("[01459]"))) {
                paramMapper.write(new Text(str2), new IntWritable(i));
   }
   } catch (StringIndexOutOfBoundsException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
                        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                        }

  }
}
