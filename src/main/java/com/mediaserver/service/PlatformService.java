package com.mediaserver.service;


import com.mediaserver.entity.Platform;

import java.util.List;

public interface PlatformService {

    public Platform create(Platform platform);

    public Platform get(int id);

    public Platform update(Platform platform);

    public Platform delete(int id);

    public List<Platform> getAll();

}
