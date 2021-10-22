package com.vibbra.datasources.feign;

//@Component
//public class KeycloakAuthenticate implements AuthenticatePort {
//
//    private final AuthenticateFeign authenticateFeign;
//    private final UserData userData;
//
//    public KeycloakAuthenticate(AuthenticateFeign authenticateFeign, UserData userData) {
//        this.authenticateFeign = authenticateFeign;
//        this.userData = userData;
//    }
//
//    @Override
//    public AuthenticationResponse authenticate(AuthenticationRequest request) {
//
//        if (userData.findByLogin(request.getLogin()).isPresent()) {
//            var getUserData = userData.findByLogin(request.getLogin()).get();
//            var token = this.getToken(request);
//            var mapper = UserModelMapper.INSTANCE;
//            var user = mapper.map(getUserData);
//            return new AuthenticationResponse(token.getAccessToken(), user);
//        }
//        throw new RuntimeException("User not find");
//    }
//
//    private TokenResponse getToken(AuthenticationRequest request) {
//        return authenticateFeign.authentication(new TokenRequest(request.getLogin(), request.getPassword(), "teste", "password"));
//    }
//}
