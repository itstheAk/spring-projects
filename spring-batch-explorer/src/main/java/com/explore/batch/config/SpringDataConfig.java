package com.explore.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.explore.batch.data.Car;

@Configuration
@EnableBatchProcessing
public class SpringDataConfig {
	
	@Bean
	public Job job(JobBuilderFactory jobBuilderFactory, 
					StepBuilderFactory stepBuilderFactory, 
					ItemReader<Car> reader,
					ItemProcessor<Car,Car> processor,
					ItemWriter<Car> writer) {
		
		Step step = stepBuilderFactory.get("FileLoadStep")
					.<Car, Car>chunk(100)
					.reader(reader)
					.processor(processor)
					.writer(writer)
					.build();
		return jobBuilderFactory.get("DataLoad")
				.incrementer(new RunIdIncrementer())
				.start(step)
				.build();
	}
	
	@Bean
	public FlatFileItemReader<Car> fileReader(@Value("${input}") Resource resource) {
		System.out.println("SpringDataConfig::fileReader getting File Reader");
		FlatFileItemReader<Car> reader = new FlatFileItemReader<>();
		reader.setResource(resource);
		reader.setName("CSV Reader");
		reader.setLinesToSkip(1);
		reader.setLineMapper(lineMapper());
		return reader;
	}
	
	@Bean
	public LineMapper<Car> lineMapper(){
		
		System.out.println("SpringDataConfig::lineMapper getting Line Mapper");
		
		DefaultLineMapper<Car> lineMapper = new DefaultLineMapper<>();
		
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		tokenizer.setDelimiter(",");
		tokenizer.setStrict(false);
		tokenizer.setNames(new String[] {"manufacturer", "name", "fuel", "varient", "price"});
		
		BeanWrapperFieldSetMapper<Car> beanMapper = new BeanWrapperFieldSetMapper<>();
		beanMapper.setTargetType(Car.class);
		
		lineMapper.setLineTokenizer(tokenizer);
		lineMapper.setFieldSetMapper(beanMapper);
		
		return lineMapper;
	}

}
