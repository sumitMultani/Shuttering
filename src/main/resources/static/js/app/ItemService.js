
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
			
			service.getAccountFatherNames = function() {
		        return $http.get(CONSTANTS.getAccountFatherNames);
		    }
			
			service.getItemNames = function() {
		        return $http.get(CONSTANTS.getItemNames);
		    }
			
			service.getItemSizes = function() {
		        return $http.get(CONSTANTS.getItemSizes);
		    }
			service.saveIssuedItem = function(issuedItems) {
				return $http.post(CONSTANTS.saveIssuedItem, issuedItems);
			}
			
			service.saveReceivedItem = function(receivedItems) {
				return $http.post(CONSTANTS.saveReceivedItem, receivedItems);
			}
			
			service.getItemExcessQuantity = function(itemName) {
		        return $http.get(CONSTANTS.getItemExcessQuantity+itemName);
		    }
			
			service.getIssuedRegister = function(itemName) {
		        return $http.get(CONSTANTS.getIssuedRegister);
		    }
			
			service.getReceivedRegister = function(itemName) {
		        return $http.get(CONSTANTS.getReceivedRegister);
		    }
			
			return service;
		} ]);

