package com.mediaserver.service;

import com.mediaserver.entity.Platform;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PlatformServiceImpl implements PlatformService {

    private List<Platform> platforms = new ArrayList<Platform>();

    public PlatformServiceImpl() {
        platforms.addAll( Arrays.asList(
                new Platform(0, "Test Local", "http://127.0.0.1:5555", "Test streaming from local pc."),
                new Platform(1, "Test Extermal", "http://10.3.2.15:5555", "Test streaming from external pc."),
                new Platform(2, "Test Udp", "udp://127.0.0.1", "Test udp streaming.")
        ));
    }

    @Override
    public Platform create(Platform platform) {
        platform.setId(platforms.size());
        platforms.add(platform);
        return platform;
    }

    @Override
    public Platform get(int id) {
        return platforms.get(id);
    }

    @Override
    public Platform update(Platform platform) {
        Platform cur = platforms.get(platform.getId());
        cur.setName(platform.getName());
        cur.setMulticastAddress(platform.getMulticastAddress());
        cur.setComment(platform.getComment());
        return cur;
    }

    @Override
    public Platform delete(int id) {
        return platforms.remove(id);
    }

    @Override
    public List<Platform> getAll() {
        return platforms;
    }
}
