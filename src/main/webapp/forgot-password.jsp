<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="layoutAuthentication_content">
    <main>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-5">
                    <div class="card shadow-lg border-0 rounded-lg mt-5">
                        <div class="card-header"><h3 class="text-center font-weight-light my-4">Password Recovery</h3></div>
                        <div class="card-body">
                            <div class="small mb-3 text-muted">Enter your email address and we will send you a link to reset your password.</div>
                            <form action="" method="POST">
                                <div class="form-group">
                                    <label class="small mb-1" for="inputEmailAddress">Email</label>
                                    <input class="form-control py-4" id="inputEmailAddress" type="email" name="email" aria-describedby="emailHelp" placeholder="Enter email address" />
                                </div>
                                <div class="form-group d-flex align-items-center justify-content-between mt-4 mb-0">
                                    <a class="small" href="<c:url value='/login'/>">Return to login</a>
                                    <button class="btn btn-primary" type="submit">Reset Password</button>
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
