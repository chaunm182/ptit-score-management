package com.minhchauptit.scoremanagement.aspect;

import com.minhchauptit.scoremanagement.entity.Ip;
import com.minhchauptit.scoremanagement.entity.SearchLog;
import com.minhchauptit.scoremanagement.entity.Student;
import com.minhchauptit.scoremanagement.service.IpService;
import com.minhchauptit.scoremanagement.service.SearchLogService;
import com.minhchauptit.scoremanagement.service.StudentService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.logging.Logger;

@Aspect
@Component
public class LogingAspect {
    @Autowired
    private IpService ipService;
    @Autowired
    private StudentService studentService;

    @Autowired
    private SearchLogService searchLogService;

    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(public * com.minhchauptit.scoremanagement.rest.ScoreRestController.getTranscriptByStudentIdAndSemester(..))")
    private void forSearchingScore(){}

    @Before("forSearchingScore()")
    public void logingSearch(JoinPoint joinPoint){
        logger.info("====> Before advice");
        Object[] args = joinPoint.getArgs();
        HttpServletRequest request = null;
        String studentId = null;
        for(Object arg : args){
            if (arg instanceof String){
                studentId = (String) arg;
            }
            else if(arg instanceof HttpServletRequest){
                request = (HttpServletRequest) arg;
            }
        }
        String remoteAddr;
        remoteAddr = request.getHeader("X-FORWARDED-FOR");
        if(remoteAddr==null ||remoteAddr.equals("")){
            remoteAddr = request.getRemoteAddr();
        }
        else {
            try{
                remoteAddr = remoteAddr.split(",")[0];
            }catch (Exception ex){
                logger.warning("cannot split remote address");
            }
        }
        logger.info(remoteAddr+" search: "+studentId);

        //save
        Student student = studentService.findByStudentId(studentId);
        Ip ip = ipService.findByIp(remoteAddr);
        if(ip==null){
            ip = new Ip();
            ip.setIp(remoteAddr);
        }
        SearchLog searchLog = new SearchLog();
        searchLog.setIp(ip);
        searchLog.setStudent(student);
        searchLog.setCreatedAt(new Date());
        searchLogService.save(searchLog);
    }

}
