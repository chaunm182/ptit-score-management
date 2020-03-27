package com.minhchauptit.scoremanagement.service;

import com.minhchauptit.scoremanagement.entity.Ip;

public interface IpService {
    void save(Ip ip);
    Ip findByIp(String ip);
}
