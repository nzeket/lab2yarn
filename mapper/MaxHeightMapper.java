package com.opstty.mapper;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class MaxHeightMapper extends Mapper<Object, Text, Text, FloatWritable> {
    public int first_line = 0;

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        if (first_line != 0) {
            try {
                Float height = Float.parseFloat(value.toString().split(";")[6]);
                context.write(new Text(value.toString().split(";")[3]), new FloatWritable(height));
            } catch (NumberFormatException ex) {
            }
            first_line++;
        }
    }
}
