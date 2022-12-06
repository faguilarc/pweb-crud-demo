package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.YearDto;

import java.util.List;

public interface YearService {
    List<YearDto> getYears();

    YearDto getYearById(Integer yearId);

    void createYear(YearDto year);
    void updateYear(YearDto year);
    void deleteYear(YearDto year);
}
