package com.minhchauptit.scoremanagement.util.bean;

import com.minhchauptit.scoremanagement.dto.IpDTO;
import com.minhchauptit.scoremanagement.entity.Ip;

public class IpBeanUtil {
    public static IpDTO entity2DTO(Ip ip){
        IpDTO ipDTO = new IpDTO();
        ipDTO.setId(ip.getId());
        ipDTO.setIp(ip.getIp());
        return ipDTO;
    }

    public static Ip DTO2Entity(IpDTO ipDTO){
        Ip ip = new Ip();
        ip.setId(ipDTO.getId());
        ip.setIp(ipDTO.getIp());
        return ip;
    }
}
