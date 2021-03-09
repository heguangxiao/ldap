/* global urlBase */

var app = angular.module('listDontuApp', ['ui.bootstrap', 'directive.contextMenu']);
app.controller('dontuCtrl', function ($scope, $http, $filter) {
    $scope.submit = function (form) {
        $scope.reloadFilter();
    };
    $scope.getDetail = function (str) {
        if ($scope.donTuId > 0) {
            $http({
                method: "POST",
                url: urlBase + "/donTu/detail",
                params: {donTuId: $scope.donTuId}
            }).then(function success(resp) {
                if (resp !== undefined && typeof resp === "object") {
                    $scope.result = resp.data.result;
                    $scope.data = resp.data.data;
                    if (!angular.isUndefined(str) && str !== '') {
                        $scope.result.message = str;
                    }
                }
            }, function error(response) {
                $scope.message = response.status;
            });
        }
    };
    $scope.reloadFilter = function (str) {
        $http({
            method: "POST",
            url: urlBase + "/donTu/rest/data",
            params: {crPage: $scope.crPage, maxRow: $scope.maxRow, status: $scope.status, createdBy: $scope.createdBy, browsedBy: $scope.browsedBy, search: $scope.search, donTuType: $scope.donTuType}
        }).then(function success(resp) {
            if (resp !== undefined && typeof resp === "object") {
                $scope.result = resp.data.result;
                $scope.datas = resp.data.datas;
                $scope.totalRow = resp.data.totalRow;
                if (!angular.isUndefined(str) && str !== '') {
                    $scope.result.message = str;
                }
            }
        }, function error(response) {
            $scope.message = response.status;
        });
        $scope.form0 = true;
        $scope.form1 = false;
        $scope.form2 = false;
        $scope.form3 = false;
        $scope.form4 = false;
        $scope.form5 = false;
        $scope.form6 = false;
        $scope.form7 = false;
        $scope.form8 = false;
        $scope.form9 = false;
        $scope.form10 = false;
    };
    $scope.findAllReason = function (str) {
        $http({
            method: "POST",
            url: urlBase + "/donTuType/rest/data",
            params: {}
        }).then(function success(resp) {
            if (resp !== undefined && typeof resp === "object") {
                $scope.result = resp.data.result;
                $scope.donTuTypes = resp.data.datas;
                if (!angular.isUndefined(str) && str !== '') {
                    $scope.result.message = str;
                }
            }
        }, function error(response) {
            $scope.message = response.status;
        });
    };
    $scope.init = function () {
        $scope.donTuId = 0;
        $scope.crPage = '1';
        $scope.maxRow = '20';
        $scope.status = '-1';
        $scope.createdBy = '-1';
        $scope.browsedBy = '-1';
        $scope.search = '';
        $scope.donTuType = '-1';
    };
    $scope.reset = function () {
        location.reload();
    };
    $scope.$watch('crPage + crPage', function () {
        $scope.reloadFilter();
        $scope.findAllReason();
        $scope.getDetail();
    });
    $scope.pageChanged = function () {
        $scope.crPage = this.crPage;
    };
    $scope.updateMaxRow = function () {
        $scope.crPage = 1;
        $scope.reloadFilter();
    };
    $scope.findAll = function () {
        $scope.init();
        $scope.reloadFilter();
    };
    $scope.findByCreatedId = function (e) {
        $scope.init();
        $scope.createdBy = e;
        $scope.reloadFilter();
    };
    $scope.findByBrowseId = function (e) {
        $scope.init();
        $scope.browsedBy = e;
        $scope.reloadFilter();
    };
    $scope.findByStatus = function (e) {
        $scope.status = e;
        $scope.reloadFilter();
    };
    $scope.findByDonTuType = function (e, i) {
        $scope.donTuType = e;
        $scope.donTuTypeShow = i;
        $scope.reloadFilter();
    };
    $scope.formatDate = function (date) {
        if (!angular.isUndefined(date) && date !== null)
            return $filter('date')(new Date(date), 'dd/MM/yyyy');
        else
            return "";
    };

    $scope.hideAllForm = function () {
        $scope.form0 = false;
        $scope.form1 = false;
        $scope.form2 = false;
        $scope.form3 = false;
        $scope.form4 = false;
        $scope.form5 = false;
        $scope.form6 = false;
        $scope.form7 = false;
        $scope.form8 = false;
        $scope.form9 = false;
        $scope.form10 = false;
    };
    $scope.changeFormShow = function (e) {
        $scope.hideAllForm();
        if (e === 0) {
            $scope.form0 = true;
        } else if (e === 1) {
            $scope.form1 = true;
        } else if (e === 2) {
            $scope.form2 = true;
        } else if (e === 3) {
            $scope.form3 = true;
        } else if (e === 4) {
            $scope.form4 = true;
        } else if (e === 5) {
            $scope.form5 = true;
        } else if (e === 6) {
            $scope.form6 = true;
        } else if (e === 7) {
            $scope.form7 = true;
        } else if (e === 8) {
            $scope.form8 = true;
        } else if (e === 9) {
            $scope.form9 = true;
        } else if (e === 10) {
            $scope.form10 = true;
        }
        $('#myModal').modal('hide');
    };
    $scope.form = true;
    $scope.showhideform = function () {
        if ($scope.form) {
            $scope.form = false;
        } else {
            $scope.form = true;
        }
    };
    $scope.submitForm = function (e) {
        alert(e);
    };
    $scope.changeDontuId = function (e) {
        $scope.donTuId = e;
    };
    $scope.copyDonTu = function () {
        $scope.getDetail();
        $scope.hideAllForm();
        if ($scope.data.donTuType === 1) {
            $scope.form1 = true;
        } else if ($scope.data.donTuType === 2) {
            $scope.form2 = true;
        } else if ($scope.data.donTuType === 3) {
            $scope.form3 = true;
        } else if ($scope.data.donTuType === 4) {
            $scope.form4 = true;
        } else if ($scope.data.donTuType === 5) {
            $scope.form5 = true;
        } else if ($scope.data.donTuType === 6) {
            $scope.form6 = true;
        } else if ($scope.data.donTuType === 7) {
            $scope.form7 = true;
        } else if ($scope.data.donTuType === 8) {
            $scope.form8 = true;
        } else if ($scope.data.donTuType === 9) {
            $scope.form9 = true;
        } else if ($scope.data.donTuType === 10) {
            $scope.form10 = true;
        } else {
            $scope.form0 = true;
        }
    };
});