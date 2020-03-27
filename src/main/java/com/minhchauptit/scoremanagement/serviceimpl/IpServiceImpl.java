package com.minhchauptit.scoremanagement.serviceimpl;

import com.minhchauptit.scoremanagement.entity.Ip;
import com.minhchauptit.scoremanagement.repository.IpRepository;
import com.minhchauptit.scoremanagement.service.IpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IpServiceImpl implements IpService {

    @Autowired
    private IpRepository ipRepository;

    @Override
    public void save(Ip ip) {
        ipRepository.save(ip);
    }

    @Override
    public Ip findByIp(String ip) {
        Optional<Ip> ipOptional = ipRepository.findByIp(ip);
        if(ipOptional.isPresent()) return ipOptional.get();
        return null;
    }
}
