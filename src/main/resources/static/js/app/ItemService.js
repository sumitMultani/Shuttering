
'use strict'

angular.module('demo.services', []).factory('ItemService',
		[ "$http", "CONSTANTS", function($http, CONSTANTS) {
			var service = {};
			service.getItemByIdUrl = function(itemId) {
				var url = CONSTANTS.getItemByIdUrl + itemId;
				return $http.get(url);
			}
			service.getStockStatusItems = function() {
		        return $http.get(CONSTANTS.getStockStatusItems);
		    }
			
			service.getStockItemList = function() {
		        return $http.get(CONSTANTS.getStockItemList);
		    }
			
			service.saveItem = function(items) {
				return $http.post(CONSTANTS.saveItem, items);
			}
			service.addTempItem = function(itemDto) {
				return $http.post(CONSTANTS.addTempItem, itemDto);
			}
			
			service.getCustomerAccounts = function() {
		        return $http.get(CONSTANTS.getCustomerAccounts);
		    }
			
			service.createAccount = function(account) {
				return $http.post(CONSTANTS.createAccount, account);
			}
			
			service.createSite = function(site) {
				return $http.post(CONSTANTS.createSite, site);
			}
			
			service.addIssuedItem = function(account) {
				return $http.post(CONSTANTS.addIssuedItem, account);
			}
			
			service.getSpecificData = function(itemName) {
		        return $http.get(CONSTANTS.getSpecificData, itemName);
		    }
			
			service.getAccountNames = function() {
		        return $http.get(CONSTANTS.getAccountNames);
		    }
			
			service.getIssuedAccountNames = function() {
		        return $http.get(CONSTANTS.getIssuedAccountNames);
		    }
			
			service.getAccountFatherNames = function(partyName) {
		        return $http.get(CONSTANTS.getAccountFatherNames+partyName);
		    }
			
			service.getIssuedAccountFatherNames = function(partyName) {
		        return $http.get(CONSTANTS.getIssuedAccountFatherNames+partyName);
		    }
			
			service.getItemNames = function() {
		        return $http.get(CONSTANTS.getItemNames);
		    }
			
			service.getIssuedItemNames = function() {
		        return $http.get(CONSTANTS.getIssuedItemNames);
		    }
			
			service.getItemSizes = function(itemName) {
		        return $http.get(CONSTANTS.getItemSizes+itemName);
		    }
			
			service.getIssuedItemSizes = function(itemName) {
		        return $http.get(CONSTANTS.getIssuedItemSizes+itemName);
		    }
			
			
			service.getItemSites = function() {
		        return $http.get(CONSTANTS.getItemSites);
		    }
			
			service.getIssuedItemSites = function(partyname, fathername) {
		        return $http.get(CONSTANTS.getIssuedItemSites+partyname+"/"+fathername);
		    }
			
			service.saveIssuedItem = function(issuedItems) {
				return $http.post(CONSTANTS.saveIssuedItem, issuedItems);
			}
			
			service.saveAgreement = function(agreement) {
				return $http.post(CONSTANTS.saveAgreement, agreement);
			}
			
			service.saveReceivedItem = function(receivedItems) {
				return $http.post(CONSTANTS.saveReceivedItem, receivedItems);
			}
			
			service.getItemExcessQuantity = function(itemName) {
		        return $http.get(CONSTANTS.getItemExcessQuantity+itemName);
		    }
			
			service.getIssuedRegister = function(startDate, endDate, partyName, fatherName, itemName) {
				var url = CONSTANTS.getIssuedRegister;
				if(startDate == undefined ){
					startDate = null;
				}if(endDate == undefined ){
					endDate = null;
				}if(partyName == undefined ){
					partyName = null;
				}if(fatherName == undefined ){ 
					fatherName = null;
				}if(itemName == undefined  ){ 
					itemName = null;
				} 
				url = url.replace('sdate', startDate);
				url = url.replace('edate', endDate);
				url = url.replace('pname', partyName);
				url = url.replace('fname', fatherName);
				url = url.replace('iname', itemName);
				 
		        return $http.get(url);
		    }
			
			service.getReceivedRegister = function(fromDate, toDate, partyName, fatherName, itemName) {
				var url = CONSTANTS.getReceivedRegister;
				if(startDate == undefined ){
					startDate = null;
				}if(endDate == undefined ){
					endDate = null;
				}if(partyName == undefined ){
					partyName = null;
				}if(fatherName == undefined ){ 
					fatherName = null;
				}if(itemName == undefined  ){ 
					itemName = null;
				} 
				url = url.replace('sdate', startDate);
				url = url.replace('edate', endDate);
				url = url.replace('pname', partyName);
				url = url.replace('fname', fatherName);
				url = url.replace('iname', itemName);
				 
		        return $http.get(url);
		    }
			
			service.getPendencyReport = function(partyName, fatherName, itemName, size, site) {
				var url = CONSTANTS.getPendencyReport;
				if(partyName == undefined ){
					partyName = null;
				}if(fatherName == undefined ){ 
					fatherName = null;
				}if(itemName == undefined  ){ 
					itemName = null;
				}if(size == undefined ){ 
					size = null;
				}if(site == undefined ){ 
					site = null;
				}
				url = url.replace('pname', partyName);
				url = url.replace('fname', fatherName);
				url = url.replace('iname', itemName);
				url = url.replace('isize', size);
				url = url.replace('isite', site);
				 
		        return $http.get(url);
		    }
			
			service.getDailyTransactions = function(fromDate, toDate, partyName, fatherName, itemName, size, site) {
				var url = CONSTANTS.getdailyTransactions;
				if(partyName == undefined ){
					partyName = null;
				}if(fatherName == undefined ){ 
					fatherName = null;
				}if(itemName == undefined  ){ 
					itemName = null;
				}if(size == undefined ){ 
					size = null;
				}if(site == undefined ){ 
					site = null;
				}
				
				url = url.replace('fdate', fromDate);
				url = url.replace('tdate', toDate);
				url = url.replace('pname', partyName);
				url = url.replace('fname', fatherName);
				url = url.replace('iname', itemName);
				url = url.replace('isize', size);
				url = url.replace('isite', site);
				 
		        return $http.get(url);
		    }
			
			
			return service;
		} ]);

