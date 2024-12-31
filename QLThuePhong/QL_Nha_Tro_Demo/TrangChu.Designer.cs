namespace QL_Nha_Tro_Demo
{
    partial class TrangChu
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(TrangChu));
            this.button1 = new System.Windows.Forms.Button();
            this.menuHeThong = new System.Windows.Forms.ToolStripMenuItem();
            this.menuQLTK = new System.Windows.Forms.ToolStripMenuItem();
            this.menuDangXuat = new System.Windows.Forms.ToolStripMenuItem();
            this.thoátToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.menuQLTT = new System.Windows.Forms.ToolStripMenuItem();
            this.QLNVPage = new System.Windows.Forms.ToolStripMenuItem();
            this.QLKHPage = new System.Windows.Forms.ToolStripMenuItem();
            this.QLPhongPage = new System.Windows.Forms.ToolStripMenuItem();
            this.QLDVPage = new System.Windows.Forms.ToolStripMenuItem();
            this.menuChucNang = new System.Windows.Forms.ToolStripMenuItem();
            this.CNThuePhongPage = new System.Windows.Forms.ToolStripMenuItem();
            this.CNTraPhongPage = new System.Windows.Forms.ToolStripMenuItem();
            this.CNSuDungDVPage = new System.Windows.Forms.ToolStripMenuItem();
            this.menuTimKiem = new System.Windows.Forms.ToolStripMenuItem();
            this.TKKhachHangPage = new System.Windows.Forms.ToolStripMenuItem();
            this.TKPhongPage = new System.Windows.Forms.ToolStripMenuItem();
            this.txtMenuRoleName = new System.Windows.Forms.ToolStripTextBox();
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.menuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // button1
            // 
            this.button1.BackColor = System.Drawing.Color.Red;
            this.button1.Cursor = System.Windows.Forms.Cursors.Hand;
            this.button1.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.button1.Location = new System.Drawing.Point(935, 34);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(35, 30);
            this.button1.TabIndex = 0;
            this.button1.Text = "X";
            this.button1.UseVisualStyleBackColor = false;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // menuHeThong
            // 
            this.menuHeThong.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.menuQLTK,
            this.menuDangXuat,
            this.thoátToolStripMenuItem});
            this.menuHeThong.Name = "menuHeThong";
            this.menuHeThong.Size = new System.Drawing.Size(88, 27);
            this.menuHeThong.Text = "Hệ Thống";
            // 
            // menuQLTK
            // 
            this.menuQLTK.Name = "menuQLTK";
            this.menuQLTK.Size = new System.Drawing.Size(224, 26);
            this.menuQLTK.Text = "Quản Lý Tài Khoản";
            this.menuQLTK.Click += new System.EventHandler(this.menuQLTK_Click);
            // 
            // menuDangXuat
            // 
            this.menuDangXuat.Name = "menuDangXuat";
            this.menuDangXuat.Size = new System.Drawing.Size(224, 26);
            this.menuDangXuat.Text = "Đăng Xuất";
            this.menuDangXuat.Click += new System.EventHandler(this.đăngXuấtToolStripMenuItem_Click);
            // 
            // thoátToolStripMenuItem
            // 
            this.thoátToolStripMenuItem.Name = "thoátToolStripMenuItem";
            this.thoátToolStripMenuItem.Size = new System.Drawing.Size(224, 26);
            this.thoátToolStripMenuItem.Text = "Thoát";
            this.thoátToolStripMenuItem.Click += new System.EventHandler(this.thoátToolStripMenuItem_Click);
            // 
            // menuQLTT
            // 
            this.menuQLTT.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.QLNVPage,
            this.QLKHPage,
            this.QLPhongPage,
            this.QLDVPage});
            this.menuQLTT.Name = "menuQLTT";
            this.menuQLTT.Size = new System.Drawing.Size(145, 27);
            this.menuQLTT.Text = "Quản Lý Thông Tin";
            // 
            // QLNVPage
            // 
            this.QLNVPage.Name = "QLNVPage";
            this.QLNVPage.Size = new System.Drawing.Size(228, 26);
            this.QLNVPage.Text = "Quản Lý Nhân Viên";
            this.QLNVPage.Click += new System.EventHandler(this.quảnLýNhânViênToolStripMenuItem_Click);
            // 
            // QLKHPage
            // 
            this.QLKHPage.Name = "QLKHPage";
            this.QLKHPage.Size = new System.Drawing.Size(228, 26);
            this.QLKHPage.Text = "Quản Lý Khách Hàng";
            this.QLKHPage.Click += new System.EventHandler(this.QLKHPage_Click);
            // 
            // QLPhongPage
            // 
            this.QLPhongPage.Name = "QLPhongPage";
            this.QLPhongPage.Size = new System.Drawing.Size(228, 26);
            this.QLPhongPage.Text = "Quản Lý Phòng";
            this.QLPhongPage.Click += new System.EventHandler(this.QLPhongPage_Click);
            // 
            // QLDVPage
            // 
            this.QLDVPage.Name = "QLDVPage";
            this.QLDVPage.Size = new System.Drawing.Size(228, 26);
            this.QLDVPage.Text = "Quản Lý Dịch Vụ";
            this.QLDVPage.Click += new System.EventHandler(this.QLDVPage_Click);
            // 
            // menuChucNang
            // 
            this.menuChucNang.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.CNThuePhongPage,
            this.CNTraPhongPage,
            this.CNSuDungDVPage});
            this.menuChucNang.Name = "menuChucNang";
            this.menuChucNang.Size = new System.Drawing.Size(96, 27);
            this.menuChucNang.Text = "Chức Năng";
            // 
            // CNThuePhongPage
            // 
            this.CNThuePhongPage.Name = "CNThuePhongPage";
            this.CNThuePhongPage.Size = new System.Drawing.Size(224, 26);
            this.CNThuePhongPage.Text = "Thuê Phòng";
            this.CNThuePhongPage.Click += new System.EventHandler(this.CNThuePhongPage_Click);
            // 
            // CNTraPhongPage
            // 
            this.CNTraPhongPage.Name = "CNTraPhongPage";
            this.CNTraPhongPage.Size = new System.Drawing.Size(224, 26);
            this.CNTraPhongPage.Text = "Trả Phòng";
            this.CNTraPhongPage.Click += new System.EventHandler(this.CNTraPhongPage_Click);
            // 
            // CNSuDungDVPage
            // 
            this.CNSuDungDVPage.Name = "CNSuDungDVPage";
            this.CNSuDungDVPage.Size = new System.Drawing.Size(224, 26);
            this.CNSuDungDVPage.Text = "Dịch Vụ Phòng";
            this.CNSuDungDVPage.Click += new System.EventHandler(this.CNSuDungDVPage_Click_1);
            // 
            // menuTimKiem
            // 
            this.menuTimKiem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.TKKhachHangPage,
            this.TKPhongPage});
            this.menuTimKiem.Name = "menuTimKiem";
            this.menuTimKiem.Size = new System.Drawing.Size(86, 27);
            this.menuTimKiem.Text = "Tìm Kiếm";
            // 
            // TKKhachHangPage
            // 
            this.TKKhachHangPage.Name = "TKKhachHangPage";
            this.TKKhachHangPage.Size = new System.Drawing.Size(239, 26);
            this.TKKhachHangPage.Text = "Tìm Kiếm Khách Hàng";
            this.TKKhachHangPage.Click += new System.EventHandler(this.TKKhachHangPage_Click);
            // 
            // TKPhongPage
            // 
            this.TKPhongPage.Name = "TKPhongPage";
            this.TKPhongPage.Size = new System.Drawing.Size(239, 26);
            this.TKPhongPage.Text = "Tìm Kiếm Phòng";
            this.TKPhongPage.Click += new System.EventHandler(this.TKPhongPage_Click);
            // 
            // txtMenuRoleName
            // 
            this.txtMenuRoleName.Alignment = System.Windows.Forms.ToolStripItemAlignment.Right;
            this.txtMenuRoleName.Enabled = false;
            this.txtMenuRoleName.Font = new System.Drawing.Font("Segoe UI", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtMenuRoleName.Name = "txtMenuRoleName";
            this.txtMenuRoleName.Size = new System.Drawing.Size(150, 27);
            // 
            // menuStrip1
            // 
            this.menuStrip1.ImageScalingSize = new System.Drawing.Size(20, 20);
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.menuHeThong,
            this.menuQLTT,
            this.menuChucNang,
            this.menuTimKiem,
            this.txtMenuRoleName});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(982, 31);
            this.menuStrip1.TabIndex = 1;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // TrangChu
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.ClientSize = new System.Drawing.Size(982, 603);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.menuStrip1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "TrangChu";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "DashBoad";
            this.Load += new System.EventHandler(this.TrangChu_Load);
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.ToolStripMenuItem menuHeThong;
        private System.Windows.Forms.ToolStripMenuItem menuQLTK;
        private System.Windows.Forms.ToolStripMenuItem menuDangXuat;
        private System.Windows.Forms.ToolStripMenuItem thoátToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem menuQLTT;
        private System.Windows.Forms.ToolStripMenuItem QLNVPage;
        private System.Windows.Forms.ToolStripMenuItem QLKHPage;
        private System.Windows.Forms.ToolStripMenuItem QLPhongPage;
        private System.Windows.Forms.ToolStripMenuItem QLDVPage;
        private System.Windows.Forms.ToolStripMenuItem menuChucNang;
        private System.Windows.Forms.ToolStripMenuItem CNThuePhongPage;
        private System.Windows.Forms.ToolStripMenuItem CNTraPhongPage;
        private System.Windows.Forms.ToolStripMenuItem CNSuDungDVPage;
        private System.Windows.Forms.ToolStripMenuItem menuTimKiem;
        private System.Windows.Forms.ToolStripMenuItem TKKhachHangPage;
        private System.Windows.Forms.ToolStripMenuItem TKPhongPage;
        private System.Windows.Forms.ToolStripTextBox txtMenuRoleName;
        private System.Windows.Forms.MenuStrip menuStrip1;
    }
}