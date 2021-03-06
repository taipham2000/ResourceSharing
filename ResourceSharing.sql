USE [ResourceSharing]
GO
/****** Object:  Table [dbo].[Borrow]    Script Date: 6/30/2021 7:40:41 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Borrow](
	[BorrowID] [int] NOT NULL,
	[userID] [nvarchar](100) NULL,
	[date] [datetime] NULL,
 CONSTRAINT [PK_Orders] PRIMARY KEY CLUSTERED 
(
	[BorrowID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BorrowDetail]    Script Date: 6/30/2021 7:40:41 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BorrowDetail](
	[BorrowDetailID] [int] NOT NULL,
	[BorrowID] [int] NULL,
	[statusBooking] [bit] NULL,
	[productID] [nvarchar](10) NULL,
	[quantity] [int] NULL,
 CONSTRAINT [PK_OrderDetail] PRIMARY KEY CLUSTERED 
(
	[BorrowDetailID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 6/30/2021 7:40:41 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[categoryID] [nvarchar](10) NOT NULL,
	[categoryName] [nvarchar](50) NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[categoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Levels]    Script Date: 6/30/2021 7:40:41 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Levels](
	[levelID] [int] NOT NULL,
	[levelName] [nvarchar](50) NULL,
 CONSTRAINT [PK_Levels] PRIMARY KEY CLUSTERED 
(
	[levelID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Products]    Script Date: 6/30/2021 7:40:41 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Products](
	[productID] [nvarchar](10) NOT NULL,
	[productName] [nvarchar](50) NULL,
	[quantity] [int] NULL,
	[description] [nvarchar](50) NULL,
	[levelID] [int] NULL,
	[imageUrl] [nvarchar](100) NULL,
	[status] [bit] NULL,
	[categoryID] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK_Products] PRIMARY KEY CLUSTERED 
(
	[productID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Roles]    Script Date: 6/30/2021 7:40:41 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Roles](
	[roleID] [int] NOT NULL,
	[roleName] [nvarchar](10) NULL,
 CONSTRAINT [PK_Roles] PRIMARY KEY CLUSTERED 
(
	[roleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 6/30/2021 7:40:41 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[userID] [nvarchar](100) NOT NULL,
	[userName] [nvarchar](50) NULL,
	[password] [nvarchar](10) NULL,
	[address] [nvarchar](100) NULL,
	[phone] [nvarchar](10) NULL,
	[date] [date] NULL,
	[roleID] [int] NULL,
	[status] [bit] NULL,
 CONSTRAINT [PK_Users] PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Borrow] ([BorrowID], [userID], [date]) VALUES (1, N'Hokihoa@gmail.com', CAST(N'2021-06-18T00:00:00.000' AS DateTime))
INSERT [dbo].[Borrow] ([BorrowID], [userID], [date]) VALUES (2, N'taitinpro@gmail.com', CAST(N'2021-06-18T00:00:00.000' AS DateTime))
INSERT [dbo].[Borrow] ([BorrowID], [userID], [date]) VALUES (3, N'tam@gmail.com', CAST(N'2021-06-20T00:00:00.000' AS DateTime))
INSERT [dbo].[Borrow] ([BorrowID], [userID], [date]) VALUES (4, N'tam@gmail.com', CAST(N'2021-06-20T00:00:00.000' AS DateTime))
INSERT [dbo].[Borrow] ([BorrowID], [userID], [date]) VALUES (5, N'tam@gmail.com', CAST(N'2021-06-20T00:00:00.000' AS DateTime))
INSERT [dbo].[Borrow] ([BorrowID], [userID], [date]) VALUES (6, N'tam@gmail.com', CAST(N'2021-06-20T00:00:00.000' AS DateTime))
INSERT [dbo].[Borrow] ([BorrowID], [userID], [date]) VALUES (7, N'tam@gmail.com', CAST(N'2021-06-20T00:00:00.000' AS DateTime))
INSERT [dbo].[Borrow] ([BorrowID], [userID], [date]) VALUES (8, N'tam@gmail.com', CAST(N'2021-06-20T00:00:00.000' AS DateTime))
INSERT [dbo].[Borrow] ([BorrowID], [userID], [date]) VALUES (9, N'tam@gmail.com', CAST(N'2021-06-20T00:00:00.000' AS DateTime))
INSERT [dbo].[Borrow] ([BorrowID], [userID], [date]) VALUES (10, N'tam@gmail.com', CAST(N'2021-06-20T00:00:00.000' AS DateTime))
INSERT [dbo].[Borrow] ([BorrowID], [userID], [date]) VALUES (11, N'tam@gmail.com', CAST(N'2021-06-20T00:00:00.000' AS DateTime))
INSERT [dbo].[Borrow] ([BorrowID], [userID], [date]) VALUES (12, N'tam@gmail.com', CAST(N'2021-06-20T00:00:00.000' AS DateTime))
INSERT [dbo].[Borrow] ([BorrowID], [userID], [date]) VALUES (13, N'tam@gmail.com', CAST(N'2021-06-26T00:00:00.000' AS DateTime))
INSERT [dbo].[Borrow] ([BorrowID], [userID], [date]) VALUES (14, N'tam@gmail.com', CAST(N'2021-06-26T00:00:00.000' AS DateTime))
INSERT [dbo].[Borrow] ([BorrowID], [userID], [date]) VALUES (15, N'tam@gmail.com', CAST(N'2021-06-27T00:00:00.000' AS DateTime))
INSERT [dbo].[Borrow] ([BorrowID], [userID], [date]) VALUES (16, N'tam@gmail.com', CAST(N'2021-06-27T00:00:00.000' AS DateTime))
INSERT [dbo].[Borrow] ([BorrowID], [userID], [date]) VALUES (17, N'tam@gmail.com', CAST(N'2021-06-27T00:00:00.000' AS DateTime))
INSERT [dbo].[Borrow] ([BorrowID], [userID], [date]) VALUES (18, N'tam@gmail.com', CAST(N'2021-06-27T00:00:00.000' AS DateTime))
INSERT [dbo].[Borrow] ([BorrowID], [userID], [date]) VALUES (19, N'tam@gmail.com', CAST(N'2021-06-27T00:00:00.000' AS DateTime))
INSERT [dbo].[Borrow] ([BorrowID], [userID], [date]) VALUES (20, N'Tram@gmail.com', CAST(N'2021-06-27T00:00:00.000' AS DateTime))
INSERT [dbo].[Borrow] ([BorrowID], [userID], [date]) VALUES (21, N'tam@gmail.com', CAST(N'2021-06-27T00:00:00.000' AS DateTime))
INSERT [dbo].[Borrow] ([BorrowID], [userID], [date]) VALUES (22, N'tam@gmail.com', CAST(N'2021-06-27T00:00:00.000' AS DateTime))
INSERT [dbo].[Borrow] ([BorrowID], [userID], [date]) VALUES (23, N'tam@gmail.com', CAST(N'2021-06-27T00:00:00.000' AS DateTime))
INSERT [dbo].[Borrow] ([BorrowID], [userID], [date]) VALUES (24, N'tam@gmail.com', CAST(N'2021-06-27T00:00:00.000' AS DateTime))
INSERT [dbo].[Borrow] ([BorrowID], [userID], [date]) VALUES (25, N'tam@gmail.com', CAST(N'2021-06-27T00:00:00.000' AS DateTime))
INSERT [dbo].[Borrow] ([BorrowID], [userID], [date]) VALUES (26, N'tam@gmail.com', CAST(N'2010-12-18T00:00:00.000' AS DateTime))
INSERT [dbo].[Borrow] ([BorrowID], [userID], [date]) VALUES (27, N'tam@gmail.com', CAST(N'2006-10-17T00:00:00.000' AS DateTime))
INSERT [dbo].[Borrow] ([BorrowID], [userID], [date]) VALUES (28, N'tam@gmail.com', CAST(N'2020-04-18T00:00:00.000' AS DateTime))
INSERT [dbo].[Borrow] ([BorrowID], [userID], [date]) VALUES (29, N'tam@gmail.com', CAST(N'2021-07-21T00:00:00.000' AS DateTime))
GO
INSERT [dbo].[BorrowDetail] ([BorrowDetailID], [BorrowID], [statusBooking], [productID], [quantity]) VALUES (1, 1, 1, N'1', 5)
INSERT [dbo].[BorrowDetail] ([BorrowDetailID], [BorrowID], [statusBooking], [productID], [quantity]) VALUES (2, 3, 1, N'2', 1)
INSERT [dbo].[BorrowDetail] ([BorrowDetailID], [BorrowID], [statusBooking], [productID], [quantity]) VALUES (3, 4, 1, N'2', 1)
INSERT [dbo].[BorrowDetail] ([BorrowDetailID], [BorrowID], [statusBooking], [productID], [quantity]) VALUES (4, 4, 1, N'1', 1)
INSERT [dbo].[BorrowDetail] ([BorrowDetailID], [BorrowID], [statusBooking], [productID], [quantity]) VALUES (5, 5, 1, N'1', 1)
INSERT [dbo].[BorrowDetail] ([BorrowDetailID], [BorrowID], [statusBooking], [productID], [quantity]) VALUES (6, 6, 1, N'2', 2)
INSERT [dbo].[BorrowDetail] ([BorrowDetailID], [BorrowID], [statusBooking], [productID], [quantity]) VALUES (7, 7, 1, N'1', 1)
INSERT [dbo].[BorrowDetail] ([BorrowDetailID], [BorrowID], [statusBooking], [productID], [quantity]) VALUES (8, 8, 1, N'2', 2)
INSERT [dbo].[BorrowDetail] ([BorrowDetailID], [BorrowID], [statusBooking], [productID], [quantity]) VALUES (9, 9, 1, N'2', 1)
INSERT [dbo].[BorrowDetail] ([BorrowDetailID], [BorrowID], [statusBooking], [productID], [quantity]) VALUES (10, 10, 1, N'6', 1)
INSERT [dbo].[BorrowDetail] ([BorrowDetailID], [BorrowID], [statusBooking], [productID], [quantity]) VALUES (11, 13, 1, N'2', 1)
INSERT [dbo].[BorrowDetail] ([BorrowDetailID], [BorrowID], [statusBooking], [productID], [quantity]) VALUES (12, 14, 0, N'2', 1)
INSERT [dbo].[BorrowDetail] ([BorrowDetailID], [BorrowID], [statusBooking], [productID], [quantity]) VALUES (13, 15, 0, N'2', 1)
INSERT [dbo].[BorrowDetail] ([BorrowDetailID], [BorrowID], [statusBooking], [productID], [quantity]) VALUES (14, 16, 0, N'4', 1)
INSERT [dbo].[BorrowDetail] ([BorrowDetailID], [BorrowID], [statusBooking], [productID], [quantity]) VALUES (15, 17, 0, N'4', 1)
INSERT [dbo].[BorrowDetail] ([BorrowDetailID], [BorrowID], [statusBooking], [productID], [quantity]) VALUES (16, 18, 0, N'4', 1)
INSERT [dbo].[BorrowDetail] ([BorrowDetailID], [BorrowID], [statusBooking], [productID], [quantity]) VALUES (17, 19, 0, N'2', 1)
INSERT [dbo].[BorrowDetail] ([BorrowDetailID], [BorrowID], [statusBooking], [productID], [quantity]) VALUES (18, 20, 0, N'4', 1)
INSERT [dbo].[BorrowDetail] ([BorrowDetailID], [BorrowID], [statusBooking], [productID], [quantity]) VALUES (19, 21, 0, N'4', 1)
INSERT [dbo].[BorrowDetail] ([BorrowDetailID], [BorrowID], [statusBooking], [productID], [quantity]) VALUES (20, 22, 0, N'2', 1)
INSERT [dbo].[BorrowDetail] ([BorrowDetailID], [BorrowID], [statusBooking], [productID], [quantity]) VALUES (21, 23, 0, N'4', 1)
INSERT [dbo].[BorrowDetail] ([BorrowDetailID], [BorrowID], [statusBooking], [productID], [quantity]) VALUES (22, 24, 0, N'4', 1)
INSERT [dbo].[BorrowDetail] ([BorrowDetailID], [BorrowID], [statusBooking], [productID], [quantity]) VALUES (23, 25, 0, N'2', 1)
INSERT [dbo].[BorrowDetail] ([BorrowDetailID], [BorrowID], [statusBooking], [productID], [quantity]) VALUES (24, 26, 0, N'2', 1)
INSERT [dbo].[BorrowDetail] ([BorrowDetailID], [BorrowID], [statusBooking], [productID], [quantity]) VALUES (25, 29, 0, N'4', 1)
GO
INSERT [dbo].[Category] ([categoryID], [categoryName]) VALUES (N'1', N'Cân Loại Mới')
INSERT [dbo].[Category] ([categoryID], [categoryName]) VALUES (N'2', N'Màn hình điện tử')
INSERT [dbo].[Category] ([categoryID], [categoryName]) VALUES (N'3', N'Máy may ')
INSERT [dbo].[Category] ([categoryID], [categoryName]) VALUES (N'4', N'Tivi')
GO
INSERT [dbo].[Levels] ([levelID], [levelName]) VALUES (1, N'Leader and Employee')
INSERT [dbo].[Levels] ([levelID], [levelName]) VALUES (2, N'Leader')
GO
INSERT [dbo].[Products] ([productID], [productName], [quantity], [description], [levelID], [imageUrl], [status], [categoryID]) VALUES (N'1', N'Quả cân', 1, N'Cân thế hệ mới', 1, N'2.jpg', 1, N'1')
INSERT [dbo].[Products] ([productID], [productName], [quantity], [description], [levelID], [imageUrl], [status], [categoryID]) VALUES (N'2', N'Thiết Bị Điện', 2, N'Dán điện Cách điện', 1, N'1.jpg', 1, N'2')
INSERT [dbo].[Products] ([productID], [productName], [quantity], [description], [levelID], [imageUrl], [status], [categoryID]) VALUES (N'3', N'Màn hình điện tử', 41, N'Màn hình nhận diện ', 2, N'3.jpg', 1, N'1')
INSERT [dbo].[Products] ([productID], [productName], [quantity], [description], [levelID], [imageUrl], [status], [categoryID]) VALUES (N'4', N'Máy May Điện Tử', 21, N'Máy may thế hệ cũ', 1, N'4.jpg', 1, N'3')
INSERT [dbo].[Products] ([productID], [productName], [quantity], [description], [levelID], [imageUrl], [status], [categoryID]) VALUES (N'5', N'Cân Cơ', 1, N'Cân tùy chỉnh', 1, N'5.jpg', 1, N'1')
INSERT [dbo].[Products] ([productID], [productName], [quantity], [description], [levelID], [imageUrl], [status], [categoryID]) VALUES (N'6', N'Cân Vàng', 8, N'Cân vàng và bạc', 2, N'6.jpg', 1, N'1')
INSERT [dbo].[Products] ([productID], [productName], [quantity], [description], [levelID], [imageUrl], [status], [categoryID]) VALUES (N'7', N'Sách thơ', 20, N'Sách tri thức cuộc sống', 2, N'7.png', 1, N'1')
INSERT [dbo].[Products] ([productID], [productName], [quantity], [description], [levelID], [imageUrl], [status], [categoryID]) VALUES (N'8', N'TV SamSung UHD', 13, N'TV màn hình full HD', 2, N'8.jpg', 1, N'4')
INSERT [dbo].[Products] ([productID], [productName], [quantity], [description], [levelID], [imageUrl], [status], [categoryID]) VALUES (N'9', N'TV Sony', 14, N'TV Màn hình cong', 1, N'10.jpg', 1, N'4')
INSERT [dbo].[Products] ([productID], [productName], [quantity], [description], [levelID], [imageUrl], [status], [categoryID]) VALUES (N'P001', N'Banh', 11, N'Banh deo thom ngon', 1, N'1.jpg', 1, N'1')
INSERT [dbo].[Products] ([productID], [productName], [quantity], [description], [levelID], [imageUrl], [status], [categoryID]) VALUES (N'T004', N'Truyá»n XuÃ¢n', 14, NULL, 2, N'10.jpg', 1, N'2')
GO
INSERT [dbo].[Roles] ([roleID], [roleName]) VALUES (1, N'manager')
INSERT [dbo].[Roles] ([roleID], [roleName]) VALUES (2, N'leader')
INSERT [dbo].[Roles] ([roleID], [roleName]) VALUES (3, N'employee')
GO
INSERT [dbo].[Users] ([userID], [userName], [password], [address], [phone], [date], [roleID], [status]) VALUES (N'Hokihoa@gmail.com', N'Hoa', N'123', N'Tam Tinh', N'0125478965', CAST(N'2020-12-27' AS Date), 1, 1)
INSERT [dbo].[Users] ([userID], [userName], [password], [address], [phone], [date], [roleID], [status]) VALUES (N'Ly@gmail.com', N'Ly', N'123', N'Thu Duc', N'0896523654', CAST(N'2012-10-11' AS Date), 3, 1)
INSERT [dbo].[Users] ([userID], [userName], [password], [address], [phone], [date], [roleID], [status]) VALUES (N'taipvse140850@fpt.edu.vn', N'Tai', N'1234', N'Binh Tan', N'0898121579', CAST(N'2021-05-09' AS Date), 3, 1)
INSERT [dbo].[Users] ([userID], [userName], [password], [address], [phone], [date], [roleID], [status]) VALUES (N'taitinpro@gmail.com', N'Tai', N'123', N'Binh Hung Hoa', N'0898121579', CAST(N'2019-03-08' AS Date), 1, 1)
INSERT [dbo].[Users] ([userID], [userName], [password], [address], [phone], [date], [roleID], [status]) VALUES (N'taitinpro1@gmail.com', N'123', N'taipham', N'Lien khu 5-6 , quáº­n BÃ¬nh TÃ¢n', N'0898121579', CAST(N'2020-06-07' AS Date), 2, 1)
INSERT [dbo].[Users] ([userID], [userName], [password], [address], [phone], [date], [roleID], [status]) VALUES (N'tam@gmail.com', N'Trinh', N'123', N'Binh Tan', N'0898252147', CAST(N'2008-07-08' AS Date), 2, 1)
INSERT [dbo].[Users] ([userID], [userName], [password], [address], [phone], [date], [roleID], [status]) VALUES (N'Tram@gmail.com', N'Tram', N'12345678', N'Linh Trung', N'0321457888', CAST(N'2021-06-27' AS Date), 2, 1)
GO
ALTER TABLE [dbo].[Borrow]  WITH CHECK ADD  CONSTRAINT [FK_Borrow_Users] FOREIGN KEY([userID])
REFERENCES [dbo].[Users] ([userID])
GO
ALTER TABLE [dbo].[Borrow] CHECK CONSTRAINT [FK_Borrow_Users]
GO
ALTER TABLE [dbo].[BorrowDetail]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetail_Orders] FOREIGN KEY([BorrowID])
REFERENCES [dbo].[Borrow] ([BorrowID])
GO
ALTER TABLE [dbo].[BorrowDetail] CHECK CONSTRAINT [FK_OrderDetail_Orders]
GO
ALTER TABLE [dbo].[BorrowDetail]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetail_Products] FOREIGN KEY([productID])
REFERENCES [dbo].[Products] ([productID])
GO
ALTER TABLE [dbo].[BorrowDetail] CHECK CONSTRAINT [FK_OrderDetail_Products]
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FK_Products_Category] FOREIGN KEY([categoryID])
REFERENCES [dbo].[Category] ([categoryID])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FK_Products_Category]
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FK_Products_Levels] FOREIGN KEY([levelID])
REFERENCES [dbo].[Levels] ([levelID])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FK_Products_Levels]
GO
ALTER TABLE [dbo].[Users]  WITH CHECK ADD  CONSTRAINT [FK_Users_Roles] FOREIGN KEY([roleID])
REFERENCES [dbo].[Roles] ([roleID])
GO
ALTER TABLE [dbo].[Users] CHECK CONSTRAINT [FK_Users_Roles]
GO
