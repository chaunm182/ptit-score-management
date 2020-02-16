package com.minhchauptit.scoremanagement.serviceimpl;

import com.minhchauptit.scoremanagement.entity.ScoreDetail;
import com.minhchauptit.scoremanagement.repository.ScoreDetailRepository;
import com.minhchauptit.scoremanagement.service.ScoreDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ScoreDetailServiceImpl implements ScoreDetailService {

    @Autowired
    private ScoreDetailRepository scoreDetailRepository;
    @Override
    public void saveScoreDetail(ScoreDetail scoreDetail) {
        scoreDetailRepository.save(scoreDetail);
    }
}
