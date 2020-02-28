package com.minhchauptit.scoremanagement.response;

import com.minhchauptit.scoremanagement.dto.StudentSuggestionDTO;

import java.util.List;

public class StudentSuggestionResponse {
    private List<StudentSuggestionDTO> suggestions;

    public List<StudentSuggestionDTO> getSuggestions() {
        return suggestions;
    }

    public void setSuggestion(List<StudentSuggestionDTO> suggestions) {
        this.suggestions = suggestions;
    }
}
