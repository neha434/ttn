package com.springboot.ecommerceApplication.domain;

import com.springboot.ecommerceApplication.domain.user.User;

import javax.persistence.*;
import java.security.Timestamp;
import java.util.Calendar;
import java.util.Date;

//    public class VerificationToken {
//        private static final int EXPIRATION = 60 * 24;
//
//        @Id
//        @GeneratedValue(strategy = GenerationType.AUTO)
//        private Integer id;
//
//        private String token;
//
//        @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
//        @JoinColumn(nullable = false, name = "user_id")
//        private User user;
//
//        private Date expiryDate;
//
//        public VerificationToken(Integer id, String token, User user, Date expiryDate) {
//            this.id = id;
//            this.token = token;
//            this.user = user;
//            this.expiryDate = expiryDate;
//        }
//
//        public VerificationToken(String token, User user) {
//            this.token = token;
//            this.user = user;
//        }
//
//        private Date calculateExpiryDate(int expiryTimeInMinutes) {
//            Calendar cal = Calendar.getInstance();
//            cal.setTime(new Timestamp(cal.getTime().getTime()));
//            cal.add(Calendar.MINUTE, expiryTimeInMinutes);
//            return new Date(cal.getTime().getTime());
//        }
//
//}
