'use strict'

var module = angular.module('demo.controllers', []);
module.controller("ItemController", [ "$scope", "ItemService",
		function($scope, ItemService, $window) {
			$scope.Items = [];
			$scope.IssuedItems = [];
			$scope.ReceivedItems = [];
			$scope.quantity = "";
			//$scope.issuedRegisterItems = [];
			$scope.Add = function() {
				// Add the new item to the Array.
				var item = {};
				item.itemName = $scope.itemDto.itemName;
				item.length = $scope.itemDto.length;
				item.width = $scope.itemDto.width;
				item.squareFeet = $scope.itemDto.squareFeet;
				item.rate = $scope.itemDto.rate;
				item.per = $scope.itemDto.per;
				item.brokerCharges = $scope.itemDto.brokerCharges;
				item.stock = $scope.itemDto.stock;
				item.rentPerDay = $scope.itemDto.rentPerDay;
				$scope.Items.push(item);

				// Clear the TextBoxes.
				$scope.itemDto.itemName = "";
				$scope.itemDto.length = "";
				$scope.itemDto.width = "";
				$scope.itemDto.squareFeet = "";
				$scope.itemDto.rate = "";
				$scope.itemDto.per = "";
				$scope.itemDto.stock = "";
				$scope.itemDto.brokerCharges = "";
				$scope.itemDto.rentPerDay = "";
			};

			// perform action on double click.
			$scope.doubleClick = function(itemName) {
				alert(itemName);
				ItemService.getSpecificData(itemName).then(function(value) {
					$scope.items = value.data;
				});
//			    alert(itemName);
//			    $scope.getItemName = itemName;
//			    $scope.items = "http://localhost:8080/stockItem/specificItem/"+itemName;
			     
			   // window.open("http://localhost:8080/stockItem/specificItem/"+itemName);
				//window.location = "http://localhost:8080/stockItem/specificItem/"+itemName;
			};
			
			// Add issued Item
			$scope.AddIssuedItem = function() {
				// Add the new item to the Array.
				var itemIssued = {};
				itemIssued.issuedDate = $scope.itemIssuedDto.issuedDate;
				itemIssued.transactionType = $scope.itemIssuedDto.transactionType;
				itemIssued.challanNo = $scope.itemIssuedDto.challanNo;
				itemIssued.partyName = $scope.itemIssuedDto.partyName;
				itemIssued.fatherName = $scope.itemIssuedDto.fatherName;
				itemIssued.itemName = $scope.itemIssuedDto.itemName;
				itemIssued.size = $scope.itemIssuedDto.size;
				itemIssued.quantity = $scope.itemIssuedDto.quantity;
				itemIssued.excessQuantity = $scope.itemIssuedDto.excessQuantity;
				itemIssued.breakage = $scope.itemIssuedDto.breakage;
				itemIssued.shortage = $scope.itemIssuedDto.shortage;
				$scope.IssuedItems.push(itemIssued);
				// Clear the TextBoxes.
				//$scope.itemIssuedDto.issuedDate = "";
				$scope.itemIssuedDto.transactionType = "";
				//$scope.itemIssuedDto.challanNo = "";
				//$scope.itemIssuedDto.partyName = "";
				$scope.itemIssuedDto.itemName = "";
				$scope.itemIssuedDto.size = "";
				$scope.itemIssuedDto.quantity = "";
				$scope.itemIssuedDto.excessQuantity = "";
				$scope.itemIssuedDto.breakage = "";
				$scope.itemIssuedDto.shortage = "";
			};

			// Received Items
			// Add issued Item
			$scope.AddReceivedItem = function() {
				// Add the new item to the Array.
				var itemReceived = {};
				itemReceived.receivedDate = $scope.itemReceivedDto.receivedDate;
				itemReceived.transactionType = $scope.itemReceivedDto.transactionType;
				itemReceived.challanNo = $scope.itemReceivedDto.challanNo;
				itemReceived.partyName = $scope.itemReceivedDto.partyName;
				itemReceived.fatherName = $scope.itemReceivedDto.fatherName;
				itemReceived.itemName = $scope.itemReceivedDto.itemName;
				itemReceived.size = $scope.itemReceivedDto.size;
				itemReceived.quantity = $scope.itemReceivedDto.quantity;
				itemReceived.excessQuantity = $scope.itemReceivedDto.excessQuantity;
				itemReceived.breakage = $scope.itemReceivedDto.breakage;
				itemReceived.shortage = $scope.itemReceivedDto.shortage;
				$scope.ReceivedItems.push(itemReceived);

				// Clear the TextBoxes.
				//$scope.itemIssuedDto.issuedDate = "";
				$scope.itemReceivedDto.transactionType = "";
				//$scope.itemIssuedDto.challanNo = "";
				//$scope.itemIssuedDto.partyName = "";
				$scope.itemReceivedDto.itemName = "";
				$scope.itemReceivedDto.size = "";
				$scope.itemReceivedDto.quantity = "";
				$scope.itemReceivedDto.excessQuantity = "";
				$scope.itemReceivedDto.breakage = "";
				$scope.itemReceivedDto.shortage = "";
			};

			
			
			$scope.Remove = function(index) {
				// Find the record using Index from Array.
				var name = $scope.Items[index].itemName;
				var val = confirm("Do you want to remove.")

				if (val == true) {
					// Remove the item from Array using Index.
					$scope.Items.splice(index, 1);
				}
			};

			// save Item or Item List
			$scope.saveItem = function() {
				ItemService.saveItem($scope.Items).then(function() {
					console.log("Saving Items.");
					$scope.Items = [];
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			};

			// Add Item button functionality.
			$scope.addTempItem = function(item) {
				console.log(item);
				$scope.itemDto.push(item);
				// Clear the TextBoxes.
				$scope.itemName = "";
				$scope.length = "";

			};

			// calculate sq feet and rentPerDay
			$scope.calculateSqFt = function(x, y) {
				$scope.itemDto.squareFeet = x * y;
			};

			$scope.calculateRentPerDay = function(rate) {
				$scope.itemDto.rentPerDay = rate;
			};

			// list items
			$scope.listItem = function() {
				ItemService.getStockStatusItems().then(function(value) {
					$scope.items = value.data;
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});

				$scope.itemDto = {
					itemId : null,
					itemName : null,
					stock : null
				};
			};

			// getDataBasedOnItem
			//-----------------------------------------------
			/*$scope.getDataBasedOnItem = function($scope.getItemName) {
				//alert($scope.getItemName);
				ItemService.getAllItems().then(function(value) {
					$scope.items = value.data;
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});

				$scope.itemDto = {
					itemId : null,
					itemName : null,
					stock : null
				};
			};*/
			
			// total stock item list
			//
			$scope.listStockItem = function() {
				ItemService.getStockItemList().then(function(value) {
					$scope.items = value.data;
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});

				$scope.itemDto = {
					itemId : null,
					itemName : null,
					stock : null
				};
			};

			
			
			//------------------------------------
			//issued Register
			$scope.issuedRegister = function() {
				ItemService.getIssuedRegister().then(function(value) {
					$scope.issuedRegisterItems = value.data;
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});

				$scope.itemDto = {
					itemId : null,
					itemName : null,
					stock : null
				};
			};
			
			//-------------
			$scope.receivedRegister = function() {
				ItemService.getReceivedRegister().then(function(value) {
					$scope.receivedRegisterItems = value.data;
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});

				$scope.itemDto = {
					itemId : null,
					itemName : null,
					stock : null
				};
			};
			// --------------------------------------------
			// get all Customer Accounts
			$scope.getCustomerAccounts = function() {
				ItemService.getCustomerAccounts().then(function(value) {
					$scope.accounts = value.data;
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			};

			// --------------------------
			//			
			$scope.getStockStatusItems = function() {
				ItemService.getStockStatusItems().then(function(value) {
					$scope.items = value.data;
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			};

			 
			//get AccountNames
			$scope.getAccountNames = function() {
				ItemService.getAccountNames().then(function(value) {
					$scope.accountNames = value.data;
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			};
			
			//get account Father name
			$scope.getAccountFatherNames = function() {
				ItemService.getAccountFatherNames().then(function(value) {
					$scope.accountFatherNames = value.data;
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			};
			//-------------------------------------------------
			// get Item Names
			$scope.getItemNames = function() {
				ItemService.getItemNames().then(function(value) {
					$scope.itemNames = value.data;
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			};
			
			//-------------------------------------------------
			// get Item Sizes
			$scope.getItemSizes = function() {
				ItemService.getItemSizes().then(function(value) {
					$scope.itemSizes = value.data;
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			};
			// ---------------------------------------------
			// save Account
			$scope.createAccount = function(account) {
				ItemService.createAccount(account).then(function() {
					console.log("Saving Items.");
					$scope.accountDto = [];
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			};

			// save Account
			$scope.createSite = function(site) {
				ItemService.createSite(site).then(function() {
					console.log("Saving Items.");
					$scope.siteDto = [];
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			};
			// --------------------------------------
			// save issued item data
			$scope.addIssuedItem = function(issuedItem) {
				ItemService.addIssuedItem(issuedItem).then(function() {
					console.log("Saved Issued Items.");
					$scope.IssuedItems = [];
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			};
			
			// save Issued Item or item List.
			$scope.saveIssuedItem = function() {
				ItemService.saveIssuedItem($scope.IssuedItems).then(function() {
					console.log("Saved issued Items.");
					$scope.IssuedItems = [];
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			};
			
			
			//saveReceivedItem
			$scope.saveReceivedItem = function() {
				ItemService.saveReceivedItem($scope.ReceivedItems).then(function() {
					console.log("Saved issued Items.");
					$scope.ReceivedItems = [];
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			};
			
			//get Excess Quantity
			$scope.getItemExcessQuantity = function(itemName) {
				ItemService.getItemExcessQuantity(itemName).then(function(value) {
					$scope.itemIssuedDto.excessQuantity = value.data;
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			};
			//----------------------------------------------------
			
			/*$scope.items = [{name: "item #1", editing: false}, 
			                {name: "item #2", editing: false}, 
			                {name: "item #3", editing: false}];*/

			$scope.editItem = function (item) {
			    item.editing = true;
			}

			$scope.doneEditing = function (item) {
			    item.editing = false;
			    //dong some background ajax calling for persistence...
			};
			
			//--------------------------------------
			$scope.getReceivedItemExcessQuantity = function(itemName) {
				ItemService.getItemExcessQuantity(itemName).then(function(value) {
					$scope.itemReceivedDto.excessQuantity = value.data;
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			};
		} ]);