package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.Drop_out_causeDto;
import cu.edu.cujae.pweb.utils.ApiRestMapper;
import cu.edu.cujae.pweb.utils.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Drop_out_causeServiceImpl implements Drop_out_causeService{
    @Autowired
    private RestService restService;
    @Override
    public List<Drop_out_causeDto> getDrop_out_cause() {

        List<Drop_out_causeDto> drop_out_causeList = new ArrayList<Drop_out_causeDto>();
        try {
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            ApiRestMapper<Drop_out_causeDto> apiRestMapper = new ApiRestMapper<>();
            String response = (String)restService.GET("/api/v1/drop_out_causes", params, String.class).getBody();
            drop_out_causeList = apiRestMapper.mapList(response, Drop_out_causeDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return drop_out_causeList;
    }

    @Override
    public Drop_out_causeDto getDrop_out_causeById(Integer drop_out_causeId) {
        Drop_out_causeDto drop_out_cause = null;

        try {
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            ApiRestMapper<Drop_out_causeDto> apiRestMapper = new ApiRestMapper<>();

            UriTemplate template = new UriTemplate("/api/v1/drop_out_cause/{drop_out_causeId}");
            String uri = template.expand(drop_out_causeId).toString();
            String response = (String)restService.GET(uri, params, String.class).getBody();
            drop_out_cause = apiRestMapper.mapOne(response, Drop_out_causeDto.class);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return drop_out_cause;
    }

    @Override
    public void createDrop_out_cause(Drop_out_causeDto drop_out_cause) {
        restService.POST("/api/v1/drop_out_causes", drop_out_cause, String.class).getBody();
    }

    @Override
    public void updateDrop_out_cause(Drop_out_causeDto drop_out_cause) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        restService.PUT("/api/v1/drop_out_causes", params, drop_out_cause, String.class).getBody();
    }

    @Override
    public void deleteDrop_out_cause(Drop_out_causeDto drop_out_cause) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        UriTemplate template = new UriTemplate("/api/v1/drop_out_causes/{drop_out_cause}");
        String uri = template.expand(drop_out_cause).toString();
        restService.DELETE(uri, params, String.class, null).getBody();
    }
}
