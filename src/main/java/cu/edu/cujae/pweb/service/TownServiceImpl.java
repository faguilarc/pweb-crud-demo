package cu.edu.cujae.pweb.service;

import cu.edu.cujae.pweb.dto.TownDto;
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
public class TownServiceImpl implements TownService{
    @Autowired
    private RestService restService;
    @Override
    public List<TownDto> getTowns() {

        List<TownDto> townDtosList = new ArrayList<TownDto>();
        try {
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            ApiRestMapper<TownDto> apiRestMapper = new ApiRestMapper<>();
            String response = (String)restService.GET("/api/v1/towns", params, String.class).getBody();
            townDtosList = apiRestMapper.mapList(response, TownDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return townDtosList;
    }

    @Override
    public TownDto getTownById(Integer townId) {
        TownDto town = null;

        try {
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            ApiRestMapper<TownDto> apiRestMapper = new ApiRestMapper<>();

            UriTemplate template = new UriTemplate("/api/v1/towns/{townId}");
            String uri = template.expand(townId).toString();
            String response = (String)restService.GET(uri, params, String.class).getBody();
            town = apiRestMapper.mapOne(response, TownDto.class);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return town;
    }

    @Override
    public void createTown(TownDto town) {
        restService.POST("/api/v1/towns", town, String.class).getBody();
    }

    @Override
    public void updateTown(TownDto town) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        restService.PUT("/api/v1/towns", params, town, String.class).getBody();
    }

    @Override
    public void deleteTown(TownDto town) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        UriTemplate template = new UriTemplate("/api/v1/towns/{town}");
        String uri = template.expand(town).toString();
        restService.DELETE(uri, params, String.class, null).getBody();
    }
}
