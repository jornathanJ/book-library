/**
 * 특정 메소스에만 적용하기 위해서 어노테이션을 이용한 AOP
 */

package com.jornathan.booklibrary.advice;


import com.jornathan.booklibrary.annotation.TokenRequired;
import com.jornathan.booklibrary.service.SecurityServiceImpl;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Aspect
@Component
public class TokenRequiredAspect {

  Logger logger = LoggerFactory.getLogger(LogAspect.class);

  @Before("@annotation(tokenRequired)")
  public void tokenRequiredWithAnnotation(TokenRequired tokenRequired) throws Throwable {
    logger.info("Before tokenRequiredWithAnnotation");

    ServletRequestAttributes requestAttributes =
        (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();

    HttpServletRequest request = requestAttributes.getRequest();

    //check for token in request header
    String tokerInHeader = request.getHeader("token");
    if (StringUtils.isEmpty(tokerInHeader)) {
      throw new IllegalArgumentException("Empty token");
    }

    Claims claims = Jwts.parser().setSigningKey(DatatypeConverter
                                                    .parseBase64Binary(SecurityServiceImpl.secretKey))
                        .parseClaimsJws(tokerInHeader).getBody();

    if (claims == null || claims.getSubject() == null) {
      throw new IllegalArgumentException("Token error : Claim is null");
    }

    if (!claims.getSubject().equalsIgnoreCase("kim")) {
      throw new IllegalArgumentException("Subject doesn't match in the token.");
    }
  }
}
