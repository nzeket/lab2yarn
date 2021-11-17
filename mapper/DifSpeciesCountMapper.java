package com.opstty.mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class DifSpeciesCountMapper extends Mapper<Object, Text, Text, IntWritable> {
    public int first_line = 0 ;
    public void map(Object key,Text value,Context context) throws IOException, InterruptedException{
        if ( first_line!= 0 ){
            context.write(new Text(value.toString().split(";")[3]), new IntWritable(1));
        }
        first_line++;
    }
}
