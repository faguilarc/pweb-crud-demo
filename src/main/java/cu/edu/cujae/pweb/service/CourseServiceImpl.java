package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.CourseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    @Override
    public List<CourseDto> getCourses() {

        List<CourseDto> courses = new ArrayList<>();

        courses.add(new CourseDto(1,"2018-2019",new Date(3092018),new Date(12072019)));
        courses.add(new CourseDto(2,"2019-2020",new Date(3092018),new Date(12072019)));
        courses.add(new CourseDto(3,"2020-2021",new Date(3092018),new Date(12072019)));
        courses.add(new CourseDto(4,"2021-2022",new Date(3092018),new Date(12072019)));

        return courses;
    }

    @Override
    public void createCourse(CourseDto course) {

    }

    @Override
    public void updateCourse(CourseDto course) {

    }

    @Override
    public void deleteCourse(CourseDto course) {

    }
}
