<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="layoutAuthentication_content">
    <main>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-5">
                    <div class="card shadow-lg border-0 rounded-lg mt-5">
                        <div class="card-header"><h3 class="text-center font-weight-light my-4">Login</h3></div>
                        <div class="card-body">
                            <form action="" method="POST">
                                <div class="form-group">
                                    <label class="small mb-1" for="inputUsername">Username</label>
                                    <input class="form-control py-4" id="inputUsername" name="username" type="text" placeholder="Enter username" autocomplete="username" />
                                </div>
                                <div class="form-group">
                                    <label class="small mb-1" for="inputPassword">Password</label>
                                    <input class="form-control py-4" id="inputPassword" name="password" type="password" placeholder="Enter password" autocomplete="password"/>
                                </div>
                                <!--                                            <div class="form-group">
                                                                                <div class="custom-control custom-checkbox">
                                                                                    <input class="custom-control-input" id="rememberPasswordCheck" type="checkbox" />
                                                                                    <label class="custom-control-label" for="rememberPasswordCheck">Remember password</label>
                                                                                </div>
                                                                            </div>-->
                                <div class="form-group d-flex align-items-center justify-content-between mt-4 mb-0">
                                    <a class="small" href="<c:url value='/forgot-password'/>">Forgot Password?</a>
                                    <button class="btn btn-primary" type="submit">Login</button>
                                </div>
                            </form>
                        </div>
                        <div class="card-footer text-center">
                            <div class="small"><a href="<c:url value='/register'/>">Need an account? Sign up!</a></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
</div>
