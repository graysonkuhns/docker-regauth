# Docker Registry Authenticator

(Initial development branch)

Rule based Docker external credential store.
Main purpose is retrieving fresh auth tokens for Amazon ECR and Google Container Registry.

External Docker credential store API briefly described here:
https://github.com/docker/docker-credential-helpers

Project is organized in modules. Many modules will become independent artifacts in groupId com.xellitix.commons later on.

Modules:
- `core` - Core RegAuth code
- `docker` - Docker data models
- `network` - Network model wrappers
- `parsing` - Application config parsing utils

All commits will be squashed before the 1.0 release.

## Authors

- [Grayson Kuhns](mailto:grayson.kuhns@xellitix.com)
