namespace QL_Nha_Tro_Demo.Entities
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("ThuePhong")]
    public partial class ThuePhong
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public ThuePhong()
        {
            SDDVs = new HashSet<SDDV>();
        }

        [Key]
        public int maThuePhong { get; set; }

        public int maKH { get; set; }

        public int maPhong { get; set; }

        public DateTime? ngayDen { get; set; }

        public DateTime? ngayDi { get; set; }

        [StringLength(50)]
        public string tinhTrangThue { get; set; }

        public virtual KhachHang KhachHang { get; set; }

        public virtual Phong Phong { get; set; }

        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<SDDV> SDDVs { get; set; }
    }
}
