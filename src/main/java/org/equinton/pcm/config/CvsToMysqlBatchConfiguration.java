/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.equinton.pcm.config;

import javax.sql.DataSource;
import org.equinton.pcm.back.entity.CollectionItem;
import org.equinton.pcm.back.repository.CollectionItemRepository;
import org.equinton.pcm.batch.cvstomysql.PcmCvsProcessor;
import org.equinton.pcm.batch.cvstomysql.PcmCvsReader;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Emmanuel
 */
@Configuration
@EnableBatchProcessing
public class CvsToMysqlBatchConfiguration {


    @Autowired
    public JobBuilderFactory jobBuilderFactory;
    
    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    
    @Autowired
    public DataSource dataSource;
    
    @Autowired
    private CollectionItemRepository collectionItemRepository;
    
    @Bean
    public PcmCvsReader reader() {
        /*Create a file reader and set  a cvs file path */
         PcmCvsReader reader = new PcmCvsReader("film.xls");
//        item.setResource(new ClassPathResource(""))
         return reader; 
    }
    
    @Bean
    public PcmCvsProcessor processor() {
        return new PcmCvsProcessor();
    }
    
    @Bean
    public RepositoryItemWriter<CollectionItem> writer() {
        RepositoryItemWriter<CollectionItem> writer = new  RepositoryItemWriter<>();
        writer.setRepository(this.collectionItemRepository);
        writer.setMethodName("save");
        return writer;
    }
    
    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1").<CollectionItem,CollectionItem> chunk(3)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }
    
    @Bean
    public Job loadDvD() {
        return this.jobBuilderFactory.get("loadDvD")
                .incrementer(new RunIdIncrementer())
                .flow(step1())
                .end()
                .build();
    }
}
