package com.mediaserver.service;

import com.mediaserver.entity.Platform;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PlatformServiceImpl implements PlatformService {
    @Override
    public Platform create(Platform platform) {
        return null;
    }

    @Override
    public Platform get(int id) {
        return null;
    }

    @Override
    public Platform update(Platform platform) {
        return null;
    }

    @Override
    public Platform delete(int id) {
        return null;
    }

    @Override
    public List<Platform> getAll() {
        return Arrays.asList(
                new Platform(1, "Test Local", "http://127.0.0.1:5555", "Test streaming from local pc."),
                new Platform(1, "Test Extermal", "http://10.3.2.15:5555", "Test streaming from external pc."),
                new Platform(1, "Test Udp", "udp://127.0.0.1", "Test udp streaming.")
        );
    }
}
