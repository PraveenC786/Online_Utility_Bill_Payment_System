package com.jsp.UtilityBillPayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineUtilityBillPaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineUtilityBillPaymentApplication.class, args);
	}

}


/*
 *Hibernate: 
    create table bills (
        bill_id bigint not null auto_increment,
        amount float(53) not null,
        due_date date,
        status enum ('FAILED','PAID','PENDING'),
        utility_type enum ('ELECTRICITY','GAS','INTERNET','WATER'),
        user_id bigint,
        primary key (bill_id)
    ) engine=InnoDB
Hibernate: 
    create table payments (
        payment_id bigint not null auto_increment,
        amount_paid float(53) not null,
        payment_date date,
        status enum ('FAILED','PAID','PENDING'),
        bill_id bigint,
        primary key (payment_id)
    ) engine=InnoDB
Hibernate: 
    create table users (
        user_id bigint not null auto_increment,
        email varchar(255),
        name varchar(255),
        phone varchar(255),
        role enum ('ADMIN','USER'),
        primary key (user_id)
    ) engine=InnoDB
Hibernate: 
    alter table payments 
       drop index UKf2by53bhocdyuce9viagny9mn
Hibernate: 
    alter table payments 
       add constraint UKf2by53bhocdyuce9viagny9mn unique (bill_id)
Hibernate: 
    alter table bills 
       add constraint FKk8vs7ac9xknv5xp18pdiehpp1 
       foreign key (user_id) 
       references users (user_id)
Hibernate: 
    alter table payments 
       add constraint FK9565r6579khpdjxnyla0l2ycd 
       foreign key (bill_id) 
       references bills (bill_id)
 * 
 * */
 