<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="layoutAuthentication_content">
    <main>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-7">
                    <div class="card shadow-lg border-0 rounded-lg mt-5">
                        <div class="card-header"><h3 class="text-center font-weight-light my-4">Create Account</h3></div>
                        <div class="card-body">
                            <form action="" method="POST">
                                <div class="form-group">
                                    <label class="small mb-1" for="inputFullname">Fullname</label>
                                    <input class="form-control py-4" id="inputFullname" type="text" name="fullname" placeholder="Enter full name" />
                                </div>
                                <div class="form-group">
                                    <label class="small mb-1" for="inputUsername">Username</label>
                                    <input class="form-control py-4" id="inputUsername" type="text" name="username" placeholder="Enter user name" autocomplete="username" />
                                </div>
                                <div class="form-group">
                                    <label class="small mb-1" for="inputEmailAddress">Email</label>
                                    <input class="form-control py-4" id="inputEmailAddress" type="email" name="email" aria-describedby="emailHelp" placeholder="Enter email address" />
                                </div>
                                <div class="form-row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label class="small mb-1" for="inputPassword">Password</label>
                                            <input class="form-control py-4" id="inputPassword" type="password" name="password" placeholder="Enter password" autocomplete="password" />
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label class="small mb-1" for="inputConfirmPassword">Confirm Password</label>
                                            <input class="form-control py-4" id="inputConfirmPassword" type="password" name="cfPassword" placeholder="Confirm password" autocomplete="confirm-password" />
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group mt-4 mb-0">
                                    <button class="btn btn-primary btn-block" type="submit">Create Account</button>
                                </div>
                            </form>
                        </div>
                        <div class="card-footer text-center">
                            <div class="small"><a href="<c:url value="/login" />">Have an account? Go to login</a></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
</div>
